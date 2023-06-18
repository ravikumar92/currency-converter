package com.learning.currencyconverter.currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/currency")
public class CurrencyController {

    private final CurrencyService currencyService;

    @Autowired
    public CurrencyController(CurrencyService currencyService){
        this.currencyService = currencyService;
    }

    @GetMapping
    public List<Currency> getConvertedCurrencyList(){
        return  currencyService.getCurrencies();
    }

    @PostMapping
    public void saveCurrency(@RequestBody Currency currency){
        currencyService.persistCurrency(currency);
    }
}
