import br.com.zenon.fraud.*;

import java.util.ArrayList;
import java.util.List;

import static br.com.zenon.fraud.Transaction.Type.*;

public class main {
    static void main(String[] args) {
        List<Transaction> lisTransaction = new ArrayList<>();
        lisTransaction.add(new Transaction(
                1,
                PAYMENT,
                9839.64,
                new Account("C1231006815", 170136.0, 160296.36),
                new Account("M1979787155", 0,0),
                0,
                0
        ));
        lisTransaction.add(new Transaction(
                743,
                CASH_OUT,
                850002.52,
                new Account("C1280323807", 850002.52, 0),
                new Account("C873221189",6510099.11,7360101.63),
                1,
                0

        ));
        for (int transaction = 0; transaction < lisTransaction.size(); transaction++){
            System.out.println("\nTransacao " + (transaction + 1 ) + " : ");
            System.out.println(lisTransaction.get(transaction));
        }



    }
}
