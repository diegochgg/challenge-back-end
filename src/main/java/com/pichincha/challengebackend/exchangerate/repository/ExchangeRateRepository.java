package com.pichincha.challengebackend.exchangerate.repository;

import com.pichincha.challengebackend.exchangerate.model.ExchangeRateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRateEntity, Long> {

    Optional<ExchangeRateEntity> findByOriginCurrencyAndDestinationCurrency(String originCurrency, String destinationCurrency);

}
