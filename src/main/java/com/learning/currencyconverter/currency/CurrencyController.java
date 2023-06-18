package com.learning.currencyconverter.currency;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
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
        return  currencyService.getConvertedCurrencies();
    }

    @PostMapping
    public List<Currency> saveCurrency(@RequestBody Currency currency) throws JsonProcessingException {
        return currencyService.persistCurrency(currency);
    }

    @GetMapping("supported")
    public JsonNode getCurrenciesList() throws JsonProcessingException {
        return currencyService.getCurrenciesList();
    }
}
