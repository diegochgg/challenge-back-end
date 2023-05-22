package com.pichincha.challengebackend.exchangerate.service;

import com.pichincha.challengebackend.exchangerate.dto.*;
import io.reactivex.Single;

public interface ExchangeRateService {

    Single<GeneralExchangeRateResponse> createExchangeRate(ExchangeRateRequest request);

    Single<GeneralExchangeRateResponse> updateExchangeRate(ExchangeRateRequest request, String exchangeRateId);

    Single<GeneralExchangeRateResponse> searchExchangeRate(SearchExchangeRateRequest request);

    Single<CalculationExchangeRateResponse> calculateExchangeRate(CalculationExchangeRateRequest request);

}
