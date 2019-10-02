package com.klarna.risk.decision.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The implementation of the {@link CreditHistoryRepository} interface.
 */
public class CreditHistoryRepositoryImpl implements CreditHistoryRepository {

    List<Transaction> transactions = new ArrayList<>();

    @Override
    public Collection<Transaction> lookupTransactions(String email) {
        return transactions.stream().
                filter(transaction -> transaction.getEmail().equals(email)).
                collect(Collectors.toList());
    }

    @Override
    public Collection<Transaction> lookupTransactions(String email, String reason) {
        return transactions.stream().
                filter(transaction -> transaction.getEmail().equals(email) && transaction.getDecision().getReason().equals(reason)).
                collect(Collectors.toList());
    }

    @Override
    public void persistTransaction(String email, CreditDecision decision, int amount) {
        transactions.add(new Transaction(email, decision, amount));
    }
}
