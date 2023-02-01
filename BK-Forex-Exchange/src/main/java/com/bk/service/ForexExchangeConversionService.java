package com.bk.service;

import com.bk.model.ForexExchangeConversion;

import java.math.BigDecimal;

public interface ForexExchangeConversionService {
    ForexExchangeConversion currencyExchange(String from, String to, BigDecimal amount);
}
