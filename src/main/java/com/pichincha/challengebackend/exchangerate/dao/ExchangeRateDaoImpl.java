package com.pichincha.challengebackend.exchangerate.dao;

import com.pichincha.challengebackend.exchangerate.model.ExchangeRateEntity;
import com.pichincha.challengebackend.exchangerate.repository.ExchangeRateRepository;
import com.pichincha.challengebackend.utils.exception.ApiException;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ExchangeRateDaoImpl implements ExchangeRateDao {

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    @Override
    public Single<ExchangeRateEntity> getExchangeRate(String exchangeRateId) {
        return Single.just(exchangeRateRepository.findById(Long.parseLong(exchangeRateId))
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "No record found.")));
    }

    @Override
    public Single<ExchangeRateEntity> createOrUpdateExchangeRate(ExchangeRateEntity entity) {
        return Single.just(exchangeRateRepository.save(entity));
    }

    @Override
    public Single<ExchangeRateEntity> findExchangeRate(String originCurrency, String destinationCurrency) {
        return Single.just(exchangeRateRepository.findByOriginCurrencyAndDestinationCurrency(originCurrency,
                destinationCurrency).orElseThrow(() ->
                new ApiException(HttpStatus.NOT_FOUND, "No record found.")));
    }

}
