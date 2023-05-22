package com.pichincha.challengebackend.exchangerate.dao;

import com.pichincha.challengebackend.exchangerate.model.ExchangeRateEntity;
import io.reactivex.Single;

public interface ExchangeRateDao {

    Single<ExchangeRateEntity> getExchangeRate(String exchangeRateId);

    Single<ExchangeRateEntity> createOrUpdateExchangeRate(ExchangeRateEntity entity);

    Single<ExchangeRateEntity> findExchangeRate(String originCurrency, String destinationCurrency);

}
