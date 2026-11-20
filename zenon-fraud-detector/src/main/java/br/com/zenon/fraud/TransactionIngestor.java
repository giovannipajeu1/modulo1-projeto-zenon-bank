package br.com.zenon.fraud;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransactionIngestor {
    public List<Transaction> ingest(String fileName) throws IOException {
        List<Transaction> transactionList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String linha;
        br.readLine();
        while ((linha = br.readLine()) != null){
        String[] campos = linha.split(",");
        int step = Integer.parseInt(campos[0]);
            Transaction.Type type = Transaction.Type.valueOf(campos[1]);
            double amount = Double.parseDouble(campos[2]);
        Account account = new Account(
                campos[3],
                Double.parseDouble(campos[4]),
                Double.parseDouble(campos[5])
        );
        Account accountDest = new Account(
                campos[6],
                Double.parseDouble(campos[7]),
                Double.parseDouble(campos[8])
        );
        int isFraud = Integer.parseInt(campos[9]);
        int isFlaggedFraud = Integer.parseInt(campos[10]);

         transactionList.add(new Transaction(step,
                 type,
                 amount,
                 account,
                 accountDest,
                 isFraud,
                 isFlaggedFraud
         ));
        }
        br.close();
        return  transactionList;
    }


}
