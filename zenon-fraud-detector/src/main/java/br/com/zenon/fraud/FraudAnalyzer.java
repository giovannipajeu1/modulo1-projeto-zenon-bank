package br.com.zenon.fraud;


import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FraudAnalyzer {
    private List<Transaction> transactionList;
    public FraudAnalyzer(List<Transaction> transactions) {
        this.transactionList = transactions;
    }

    public long contarFraudes(){
        return  transactionList.stream()
                .filter(transaction -> transaction.isFraud() == 1)
                .count();
    }
    public List<Double> topTresFraudes(){
        return  transactionList.stream()
                .filter(transaction -> transaction.isFraud() == 1)
                .sorted(Comparator.comparing(Transaction::amount).reversed())
                .limit(3)
                .map(Transaction::amount)
                .collect(Collectors.toList());

    }
    public Map<String, Double> detectaClienteFraude(){
        return  transactionList.stream()
                .filter(transaction -> transaction.isFraud() == 1)
                .collect(Collectors.groupingBy(account -> account.origin().name(), Collectors.summingDouble(Transaction::amount))
                );
    }
    public List<String> rankeiaFraude(){
        Map<String, Double> detectaedClienteFraude = detectaClienteFraude();
        return detectaedClienteFraude.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());


    }
    public Double totalDePreujuizo(){
        return transactionList.stream()
                .filter(transaction -> transaction.isFraud() == 1)
                .collect(Collectors.summingDouble(Transaction::amount));
    }

   public Map<Transaction.Type, Long> totalTiposFraudes(){
        return transactionList.stream()
                .filter(transaction ->  transaction.isFraud() == 1)
                .collect(Collectors.groupingBy(transaction -> transaction.type(), Collectors.counting()));
   }
}
