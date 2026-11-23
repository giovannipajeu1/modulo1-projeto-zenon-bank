import br.com.zenon.fraud.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static br.com.zenon.fraud.Transaction.Type.*;

public class main {
    static void main(String[] args) throws IOException {

            TransactionIngestor transactionIngestor = new TransactionIngestor();
            List<Transaction> transactionList = transactionIngestor.ingest("data/PS_20174392719_1491204439457_log.csv");
            List<Transaction> list = transactionList.stream().limit(50000).collect(Collectors.toList());
            FraudAnalyzer fraudAnalyzer = new FraudAnalyzer(list);
        System.out.println(
                "1. Total de fraudes: " +
                fraudAnalyzer.contarFraudes());
        System.out.println("2. Top 3 Fraudes de maior valor");
        fraudAnalyzer.topTresFraudes().forEach(t -> System.out.println(String.format("%.2f", t)));
        System.out.println("3. Clientes Suspeitos:");
        fraudAnalyzer.rankeiaFraude().forEach(System.out::println);
        System.out.println("4. Prejuízo Total: " + String.format("%.2f", fraudAnalyzer.totalDePreujuizo()));
        System.out.println("5. Fraudes por Tipo:");
        fraudAnalyzer.totalTiposFraudes().forEach((chave, valor) -> System.out.println(chave + " - " + valor));

         }


}
