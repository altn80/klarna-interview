/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klarna.risk.decision.domain;

/**
 *
 * @author andre
 */
public class Transaction {

    private String email;
    private CreditDecision decision;
    private int amount;

    public Transaction(String email, CreditDecision decision, int amount) {
        this.email = email;
        this.decision = decision;
        this.amount = amount;
    }

    public String getEmail() {
        return email;
    }

    public CreditDecision getDecision() {
        return decision;
    }

    public int getAmount() {
        return amount;
    }

}
