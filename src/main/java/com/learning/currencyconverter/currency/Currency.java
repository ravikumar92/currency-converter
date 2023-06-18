package com.learning.currencyconverter.currency;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class Currency {

    public Currency() {
    }
    public Currency(double amount, String currencyFrom, String setCurrencyTo) {
        this.amount = amount;
        this.currencyFrom = currencyFrom;
        this.setCurrencyTo = setCurrencyTo;
    }

    @Id
    @SequenceGenerator(
            name = "currency_sequence",
            sequenceName = "currency_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "currency_sequence"
    )

    private Long id;
    private double amount;
    private String currencyFrom;
    private  String setCurrencyTo;
    private LocalDateTime timestamp;

    @PrePersist
    protected void onCreate() {
        this.timestamp = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrencyFrom() {
        return currencyFrom;
    }

    public void setCurrencyFrom(String from) {
        this.currencyFrom = from;
    }

    public String getCurrencyTo() {
        return setCurrencyTo;
    }

    public void setCurrencyTo(String to) {
        this.setCurrencyTo = to;
    }
}
