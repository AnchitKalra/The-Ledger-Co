package com.example.geektrust.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Person {

    private String name;
    private int amount;
    private int totalEmis;

    private int emiAmount;

    private String bankName;


    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    private List<Integer> paymentList = new ArrayList<>();

    private Map<Integer, Integer> paymentMap = new HashMap<>();

    public List<Integer> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Integer> paymentList) {
        this.paymentList = paymentList;
    }

    public Map<Integer, Integer> getPaymentMap() {
        return paymentMap;
    }

    public void setPaymentMap(Map<Integer, Integer> paymentMap) {
        this.paymentMap = paymentMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTotalEmis() {
        return totalEmis;
    }

    public void setTotalEmis(int totalEmis) {
        this.totalEmis = totalEmis;
    }

    public int getEmiAmount() {
        return emiAmount;
    }

    public void setEmiAmount(int emiAmount) {
        this.emiAmount = emiAmount;
    }
}
