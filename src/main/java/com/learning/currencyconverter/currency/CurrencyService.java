package com.learning.currencyconverter.currency;

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

    public void persistCurrency(Currency currency) {
        System.out.println(currency);
        System.out.println(converter.makeApiCall());
        currencyRepository.save(currency);
    }
}
