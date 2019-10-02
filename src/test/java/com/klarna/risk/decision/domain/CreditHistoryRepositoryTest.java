/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klarna.risk.decision.domain;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author andre
 */
public class CreditHistoryRepositoryTest {

    CreditHistoryRepository creditHistoryRepository;

    @Before
    public void init() {
        creditHistoryRepository = new CreditHistoryRepositoryImpl();
        buildTransactions();
    }

    @Test
    public void testLookupTransactionsEmail() {
        Assert.assertThat(creditHistoryRepository.lookupTransactions("foo@foo.com").size(), Matchers.is(5));
    }
    
    @Test
    public void testLookupTransactionsEmailDecisionOk() {
        Assert.assertThat(creditHistoryRepository.lookupTransactions("foo@foo.com", "ok").size(), Matchers.is(1));
    }
    
    @Test
    public void testLookupTransactionsEmailDecisionDebt() {
        Assert.assertThat(creditHistoryRepository.lookupTransactions("foo@foo.com", "debt").size(), Matchers.is(3));
    }

    void buildTransactions() {
        creditHistoryRepository.persistTransaction("foo@foo.com", CreditDecision.DEBT, 10);
        creditHistoryRepository.persistTransaction("foo@foo.com", CreditDecision.ACCEPTED, 20);
        creditHistoryRepository.persistTransaction("foo@foo.com", CreditDecision.DEBT, 30);
        creditHistoryRepository.persistTransaction("foo@foo.com", CreditDecision.MAX_AMOUNT_BREACH, 40);
        creditHistoryRepository.persistTransaction("foo@foo.com", CreditDecision.DEBT, 50);

    }

}
