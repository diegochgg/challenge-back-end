package com.pichincha.challengebackend.exchangerate.controller;

import com.pichincha.challengebackend.exchangerate.dto.CalculationExchangeRateRequest;
import com.pichincha.challengebackend.exchangerate.dto.CalculationExchangeRateResponse;
import com.pichincha.challengebackend.exchangerate.dto.ExchangeRateRequest;
import com.pichincha.challengebackend.exchangerate.dto.GeneralExchangeRateResponse;
import com.pichincha.challengebackend.exchangerate.dto.SearchExchangeRateRequest;
import com.pichincha.challengebackend.exchangerate.service.ExchangeRateService;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exchange-rate")
public class ExchangeRateController {

    @Autowired
    private ExchangeRateService exchangeRateService;

    @PostMapping(value = "/create", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Single<GeneralExchangeRateResponse> createExchangeRate(
            @RequestBody ExchangeRateRequest request) {
        return exchangeRateService.createExchangeRate(request);
    }

    @PutMapping(value = "/update/{exchangeRateId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Single<GeneralExchangeRateResponse> updateExchangeRate(
            @RequestBody ExchangeRateRequest request,
            @PathVariable("exchangeRateId") String exchangeRateId
    ) {
        return exchangeRateService.updateExchangeRate(request, exchangeRateId);
    }

    @PostMapping(value = "/search", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Single<GeneralExchangeRateResponse> searchExchangeRate(
            @RequestBody SearchExchangeRateRequest request) {
        return exchangeRateService.searchExchangeRate(request);
    }

    @PostMapping(value = "/calculate", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Single<CalculationExchangeRateResponse> calculateExchangeRate(
            @RequestBody CalculationExchangeRateRequest request) {
        return exchangeRateService.calculateExchangeRate(request);
    }

}
