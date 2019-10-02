package com.klarna.risk.decision.domain;

/**
 * The implementation of the {@link CreditDecisionMaker} interface.
 */
public class CreditDecisionMakerImpl implements CreditDecisionMaker {

    @Override
    public CreditDecision makeCreditDecision(int purchaseAmount, int currentCustomerDebt) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("Invalid purchase amount");
        }
        if (purchaseAmount > 10) {
            return CreditDecision.MAX_AMOUNT_BREACH;
        }
        if (purchaseAmount + currentCustomerDebt > 100) {
            return CreditDecision.DEBT;
        }
        return CreditDecision.ACCEPTED;
    }

}
