package com.pichincha.challengebackend.exchangerate.service;

import static com.pichincha.challengebackend.utils.constants.Constants.CREATED_RESPONSE_OK;
import static com.pichincha.challengebackend.utils.constants.Constants.UPDATED_RESPONSE_OK;
import static com.pichincha.challengebackend.utils.constants.Constants.SEARCHED_RESPONSE_OK;

import com.pichincha.challengebackend.exchangerate.builder.ExchangeRateBuilder;
import com.pichincha.challengebackend.exchangerate.dao.ExchangeRateDao;
import com.pichincha.challengebackend.exchangerate.dto.CalculationExchangeRateRequest;
import com.pichincha.challengebackend.exchangerate.dto.CalculationExchangeRateResponse;
import com.pichincha.challengebackend.exchangerate.dto.ExchangeRateRequest;
import com.pichincha.challengebackend.exchangerate.dto.GeneralExchangeRateResponse;
import com.pichincha.challengebackend.exchangerate.dto.SearchExchangeRateRequest;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Autowired
    private ExchangeRateDao exchangeRateDao;

    @Autowired
    private ExchangeRateBuilder exchangeRateBuilder;

    @Override
    public Single<GeneralExchangeRateResponse> createExchangeRate(ExchangeRateRequest request) {
        return exchangeRateDao.createOrUpdateExchangeRate(exchangeRateBuilder.buildCreateToEntity(request))
                .map(createdEntity -> exchangeRateBuilder.buildToResponse(CREATED_RESPONSE_OK, createdEntity));
    }

    @Override
    public Single<GeneralExchangeRateResponse> updateExchangeRate(ExchangeRateRequest request, String exchangeRateId) {
        return exchangeRateDao.getExchangeRate(exchangeRateId)
                .flatMap(entity -> exchangeRateDao.createOrUpdateExchangeRate
                                (exchangeRateBuilder.buildUpdateToEntity(request, entity))
                        .map(response -> exchangeRateBuilder.buildToResponse(UPDATED_RESPONSE_OK, response)));
    }

    @Override
    public Single<GeneralExchangeRateResponse> searchExchangeRate(SearchExchangeRateRequest request) {
        return exchangeRateDao.findExchangeRate(request.getOriginCurrency(), request.getDestinationCurrency())
                .map(response -> exchangeRateBuilder.buildToResponse(SEARCHED_RESPONSE_OK, response));
    }

    @Override
    public Single<CalculationExchangeRateResponse> calculateExchangeRate(CalculationExchangeRateRequest request) {
        return exchangeRateDao.findExchangeRate(request.getOriginCurrency(), request.getDestinationCurrency())
                .map(response -> exchangeRateBuilder.buildCalculateToResponse(response, request));
    }

}
