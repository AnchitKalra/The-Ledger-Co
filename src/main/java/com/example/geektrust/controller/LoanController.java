package com.example.geektrust.controller;

import com.example.geektrust.service.LoanService;

public class LoanController {

    LoanService service = new LoanService();
    public void loan(String input[]) {
        service.loan(input);
    }

    public void payment(String string[]) {
        service.payment(string);
    }

    public void balance(String string[]) {
        service.balance(string);
    }
}
