package br.com.zenon.fraud;

import java.util.List;
import java.util.Optional;

public class TransactionListRepository implements TransactionRepository{
    private List<Transaction> transactionList;
    public TransactionListRepository(List<Transaction> transactions){
         this.transactionList = transactions;
    }
    public Optional<Transaction> getTransactionByName(String nameOrigin){
    return    transactionList.stream()
                .filter(account -> account.origin().name().equals(nameOrigin))
                .findFirst();

    }
}
