package com.bk.controller;

import com.bk.model.ForexExchangeConversion;
import com.bk.service.ForexExchangeConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("api/v1/bk")
public class ForexExchangeConversionController {
    private ForexExchangeConversionService forexExchangeConversionService;
    @Autowired
    public ForexExchangeConversionController(ForexExchangeConversionService forexExchangeConversionService) {
        this.forexExchangeConversionService = forexExchangeConversionService;
    }
    @PostMapping("/forex-exchange/{from}/{to}/{amount}")
    public ForexExchangeConversion currencyExchange(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal amount){

        return forexExchangeConversionService.currencyExchange(from,to,amount);
    }
}
