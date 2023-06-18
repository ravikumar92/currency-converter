package com.learning.currencyconverter.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collection;
import java.util.Collections;

@Component
public class Converter {
    private RestTemplate restTemplate;
    private Environment env;

    @Autowired
    public Converter(Environment env, RestTemplate restTemplate) {
        this.env = env;
        this.restTemplate = restTemplate;
    }

    public String makeApiCall() {
        String apiUrl = env.getProperty("app.converter.api");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<?> httpEntity = new HttpEntity<>(headers);
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(apiUrl)
                .queryParam("access_key", env.getProperty("app.converter.api_key"))
                .queryParam("from", "INR")
                .queryParam("to", "USD")
                .queryParam("amount", 10000);
        String urlWithParams = uriBuilder.build().toUriString();
        System.out.println(urlWithParams);
        return restTemplate.exchange(urlWithParams, HttpMethod.GET ,httpEntity, String.class).getBody();
    }
}
