package com.pandy.designpattern.responchain;

import java.math.BigDecimal;

public class Request {

    private final String name;
    private final BigDecimal amount;

    public Request(String name, BigDecimal amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
