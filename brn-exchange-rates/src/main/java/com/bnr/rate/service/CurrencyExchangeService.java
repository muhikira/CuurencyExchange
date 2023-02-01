package com.bnr.rate.service;

import com.bnr.rate.model.CurrencyExchange;

import java.math.BigDecimal;

public interface CurrencyExchangeService {

    CurrencyExchange createCurrencyExchange(CurrencyExchange currencyExchange);
    BigDecimal getByFromTo(String from, String to);

}
