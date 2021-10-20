package com.educational;

import lombok.Getter;

@Getter
public class Dollar extends Money {

    public Dollar(int amount, String currency) {
        super(amount, currency);
    }

}
