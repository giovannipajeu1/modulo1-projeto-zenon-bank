package br.com.zenon.fraud;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TransactionMapRepository implements TransactionRepository{
    private Map<String,Transaction> transactionMap = new HashMap<>();

    public TransactionMapRepository(List<Transaction> transactions){
         this.transactionMap = transactions.stream()
                 .collect(Collectors.toMap(transaction -> transaction.origin().name(), Function.identity()) );

    }
    public Optional<Transaction> getTransactionByName(String nomeOrigin){
        return Optional.ofNullable(transactionMap.get(nomeOrigin));
    }
}
