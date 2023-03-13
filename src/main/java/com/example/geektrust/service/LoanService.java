package com.example.geektrust.service;

import com.example.geektrust.model.Bank;
import com.example.geektrust.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LoanService {

    private List<Bank> bankList;
    private List<Person> personList;

    public LoanService() {
        bankList = new ArrayList<>();
        personList = new ArrayList<>();
    }
    public void loan(String input[]) {
        Bank bank = new Bank();
        Person person = new Person();
        String bankName = input[1];
        String personName = input[2];
        int principal = Integer.parseInt(input[3]);
        int years = Integer.parseInt(input[4]);
        int rate = Integer.parseInt(input[5]);
        bank.setBankName(bankName);
        bank.setPrincipal(principal);
        bank.setYears(years);
        bank.setRate(rate);
        bank.setPersonName(personName);
        bankList.add(bank);

        int simpleInterest = (int)Math.ceil((principal * years * (double)rate) / (double) 100);
        int amount = principal + simpleInterest;
        int totalEmis = 12 * years;
        int emiAmount = (int)Math.ceil((double)amount / (double) totalEmis);
      //  System.out.println("emiAmount" + emiAmount);
        person.setAmount(amount);
        person.setName(personName);
        person.setEmiAmount(emiAmount);
        person.setTotalEmis(totalEmis);
        person.setBankName(bank.getBankName());
        personList.add(person);
    }


    public void payment(String input[]) {
        Person p = new Person();
        for (Person person : personList) {
            if(person.getName().equalsIgnoreCase(input[2])) {
                p = person;
            }
        }
        List<Integer> list = p.getPaymentList();
        list.add(Integer.parseInt(input[4]));
        p.setPaymentList(list);
        Map<Integer, Integer> map = p.getPaymentMap();
        map.put(Integer.parseInt(input[4]), Integer.parseInt(input[3]));

    }

    public void balance(String string[]) {
        String bankName = string[1];
        String personName = string[2];
        Bank b = new Bank();
        for (Bank bank : bankList) {
            if(bank.getBankName().equalsIgnoreCase(bankName) && bank.getPersonName().equalsIgnoreCase(personName)) {
                b = bank;
            }
        }
        Person p = new Person();
        for (Person person : personList) {
            if(person.getName().equalsIgnoreCase(personName) && person.getBankName().equalsIgnoreCase(b.getBankName())) {
                p = person;
            }
        }
        int emiCount = Integer.parseInt(string[3]);
       // System.out.println("EMICOUNT->" + emiCount);
        int amountPayed = 0;
        List<Integer> list = p.getPaymentList();
        for (int i : list) {
            if(i <= emiCount) {
               amountPayed +=  p.getPaymentMap().get(i);
             //  System.out.println("Amount->" + amountPayed);
            }
        }
      //  System.out.println("EMIAMOUNT-->" + p.getEmiAmount());
        int emiPayed = emiCount * p.getEmiAmount();
     //  System.out.println("EMIPAYED-->" + emiPayed);
        amountPayed += emiPayed;
      //  System.out.println("Total Amount Payed-->" + amountPayed);

        int totalAmount = p.getAmount();
       // System.out.println("Total Amount->" + totalAmount);
        totalAmount -= amountPayed;
        //System.out.println("Remaining Amount-->" + totalAmount);
        int emiRemaining = 0;
        if(totalAmount <= p.getEmiAmount()) {
            emiRemaining = 1;
            if(totalAmount <= 0) {
                emiRemaining = 0;
                amountPayed = p.getAmount();
            }
        }
        else {
            emiRemaining = (int)Math.ceil((double)totalAmount /(double) p.getEmiAmount());
        }

        System.out.println(b.getBankName() + " " + b.getPersonName() + " " + amountPayed + " " + emiRemaining);
    }
}
