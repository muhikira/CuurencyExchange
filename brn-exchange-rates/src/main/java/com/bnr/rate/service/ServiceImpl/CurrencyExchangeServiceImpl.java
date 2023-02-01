package com.bnr.rate.service.ServiceImpl;

import com.bnr.rate.model.CurrencyExchange;
import com.bnr.rate.repository.CurrencyExchangeRepository;
import com.bnr.rate.service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {
    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    public CurrencyExchangeServiceImpl(CurrencyExchangeRepository currencyExchangeRepository) {
        this.currencyExchangeRepository = currencyExchangeRepository;
    }

    @Override
    public CurrencyExchange createCurrencyExchange(CurrencyExchange currencyExchange) {
        return currencyExchangeRepository.save(currencyExchange);
    }

    @Override
    public BigDecimal getByFromTo(String from, String to) {
        BigDecimal rate=BigDecimal.ZERO;
        List<CurrencyExchange> rates=currencyExchangeRepository.findAll();
        for (CurrencyExchange c:rates){
            if(c.getFrom().equals(from)&&to.equals(c.getTo())){
               rate=c.getConversionMultiple();
            }
        }

        return rate;
    }
}
