package com.bnr.rate.controller;

import com.bnr.rate.model.CurrencyExchange;
import com.bnr.rate.service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@CrossOrigin(origins = "http://localhost:8000")
@RestController
@RequestMapping("api/v1")
public class ExchangeServiceController {
    @Autowired
    private CurrencyExchangeService currencyExchangeService;

    public ExchangeServiceController(CurrencyExchangeService currencyExchangeService) {
        this.currencyExchangeService = currencyExchangeService;
    }
    @PostMapping("/bnr-exchange-rate")
    public CurrencyExchange createNewRate(@RequestBody CurrencyExchange currencyExchange){
        return currencyExchangeService.createCurrencyExchange(currencyExchange);
    }
    @GetMapping("/bnr-exchange-rate/{from}/{to}")
    public BigDecimal getRate(@PathVariable String from, @PathVariable String to){
        return currencyExchangeService.getByFromTo(from,to);
    }
}
