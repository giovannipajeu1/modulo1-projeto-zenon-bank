import br.com.zenon.fraud.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static br.com.zenon.fraud.Transaction.Type.*;

public class main {
    static void main(String[] args) throws IOException {

            TransactionIngestor transactionIngestor = new TransactionIngestor();
            List<Transaction> transactionList = transactionIngestor.ingest("data/PS_20174392719_1491204439457_log.csv");
            transactionList.stream()
                    .limit(10)
                    .forEach(System.out::println);
    }
}
