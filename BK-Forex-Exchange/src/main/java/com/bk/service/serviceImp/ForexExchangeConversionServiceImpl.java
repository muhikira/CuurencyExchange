package com.bk.service.serviceImp;

import com.bk.model.ForexExchangeConversion;
import com.bk.repository.ForexExchangeConversionRepository;
import com.bk.service.ForexExchangeConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class ForexExchangeConversionServiceImpl implements ForexExchangeConversionService {
    private ForexExchangeConversionRepository forexExchangeConversionRepository;
    private RestTemplate restTemplate;

@Autowired
    public ForexExchangeConversionServiceImpl(ForexExchangeConversionRepository forexExchangeConversionRepository, RestTemplate restTemplate) {
        this.forexExchangeConversionRepository = forexExchangeConversionRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public ForexExchangeConversion currencyExchange(String from, String to, BigDecimal amount) {
    String url="http://localhost:8080/api/v1/bnr-exchange-rate/"+from+"/"+to;
    BigDecimal rate=restTemplate.getForObject(url, BigDecimal.class);
        ForexExchangeConversion forexExchangeConversion=new ForexExchangeConversion();
        forexExchangeConversion.setFrom(from);
        forexExchangeConversion.setTo(to);
        forexExchangeConversion.setRate(rate);
        forexExchangeConversion.setTotal(amount.multiply(rate));

        return forexExchangeConversionRepository.save(forexExchangeConversion);
    }
}
