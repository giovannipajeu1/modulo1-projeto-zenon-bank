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
            List<Transaction> transactionList = transactionIngestor.ingest("data/paysim_with_bad_data.csv");
            transactionList.stream()
                    .forEach(System.out::println);
    }
}
