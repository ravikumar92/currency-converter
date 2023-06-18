package com.learning.currencyconverter.currency;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.learning.currencyconverter.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {
    private final  CurrencyRepository currencyRepository;
    private final Converter converter;


    @Autowired
    public CurrencyService(CurrencyRepository currencyRepository, Converter converter){
        this.currencyRepository = currencyRepository;
        this.converter = converter;

    }
    public List<Currency> getCurrencies(){
        return currencyRepository.findAll();
    }

    public List<Currency> persistCurrency(Currency currency) throws JsonProcessingException {
        JsonNode convertedCurrency = converter.makeApiCall();
        currency.setConvertedAmount(convertedCurrency.get("result").get("convertedAmount").asDouble());
        currencyRepository.save(currency);
        return List.of(currency);
    }
}
