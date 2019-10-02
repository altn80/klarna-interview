package com.klarna.risk.decision.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * A class representing customer debt which is the sum of all of the purchases done by the customer.
 */
public class CustomerDebt {

    /**
     * The primary identifier of the customer.
     */
    private String customerEmail;

    /**
     * The sum of the customer's all approved puchases.
     */
    private int debtAmount;
    
    private List<Transaction> transactions;

    public CustomerDebt() {
        // default
    }

    public CustomerDebt(String customerEmail, int debtAmount) {
        this.customerEmail = customerEmail;
        this.debtAmount = debtAmount;
        this.transactions = new ArrayList<>();
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public int getDebtAmount() {
        return debtAmount;
    }

    public void increaseDebtAmount(int amountIncrement) {
        debtAmount += amountIncrement;
    }

}
