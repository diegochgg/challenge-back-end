package com.pichincha.challengebackend.exchangerate.builder;

import static com.pichincha.challengebackend.utils.constants.Constants.ZERO;

import com.pichincha.challengebackend.exchangerate.dto.Audit;
import com.pichincha.challengebackend.exchangerate.dto.CalculationExchangeRateRequest;
import com.pichincha.challengebackend.exchangerate.dto.CalculationExchangeRateResponse;
import com.pichincha.challengebackend.exchangerate.dto.ExchangeRateRequest;
import com.pichincha.challengebackend.exchangerate.dto.ExchangeRateResponse;
import com.pichincha.challengebackend.exchangerate.dto.GeneralExchangeRateResponse;
import com.pichincha.challengebackend.exchangerate.model.ExchangeRateEntity;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class ExchangeRateBuilder {

    public ExchangeRateEntity buildCreateToEntity(ExchangeRateRequest request) {
        return ExchangeRateEntity.builder()
                .originCurrency(request.getOriginCurrency())
                .destinationCurrency(request.getDestinationCurrency())
                .exchangeRate(request.getExchangeRate())
                .deleted(Boolean.valueOf(ZERO))
                .createdBy("dchavezg")
                .createdDate(LocalDateTime.now())
                .build();
    }

    public ExchangeRateEntity buildUpdateToEntity(ExchangeRateRequest request, ExchangeRateEntity entity) {
        return ExchangeRateEntity.builder()
                .exchangeRateId(entity.getExchangeRateId())
                .originCurrency(request.getOriginCurrency())
                .destinationCurrency(request.getDestinationCurrency())
                .exchangeRate(request.getExchangeRate())
                .deleted(Boolean.valueOf(ZERO))
                .createdBy(entity.getCreatedBy())
                .createdDate(entity.getCreatedDate())
                .lastModifiedBy("dchavezg")
                .lastModifiedDate(LocalDateTime.now())
                .build();
    }

    public GeneralExchangeRateResponse buildToResponse(String result, ExchangeRateEntity entity) {
        return GeneralExchangeRateResponse.builder()
                .result(result)
                .data(buildToResponse(entity))
                .build();
    }

    public ExchangeRateResponse buildToResponse(ExchangeRateEntity entity) {
        return ExchangeRateResponse.builder()
                .exchangeRateId(entity.getExchangeRateId())
                .originCurrency(entity.getOriginCurrency())
                .destinationCurrency(entity.getDestinationCurrency())
                .exchangeRate(entity.getExchangeRate())
                .audit(Audit.builder()
                        .deleted(entity.getDeleted())
                        .createdBy(entity.getCreatedBy())
                        .createdDate(String.valueOf(entity.getCreatedDate()))
                        .lastModifiedBy(entity.getLastModifiedBy())
                        .lastModifiedDate(String.valueOf(entity.getLastModifiedDate()))
                        .build())
                .build();
    }

    public CalculationExchangeRateResponse buildCalculateToResponse(ExchangeRateEntity entity, CalculationExchangeRateRequest request) {
        return CalculationExchangeRateResponse.builder()
                .originCurrency(entity.getOriginCurrency())
                .destinationCurrency(entity.getDestinationCurrency())
                .amount(request.getAmount())
                .exchangeRate(entity.getExchangeRate())
                .calculatedAmount(request.getAmount() * entity.getExchangeRate())
                .build();
    }

}
