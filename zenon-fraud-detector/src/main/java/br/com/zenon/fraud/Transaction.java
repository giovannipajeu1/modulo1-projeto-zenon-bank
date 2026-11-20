package br.com.zenon.fraud;


public record Transaction(

        int step,
        Type type,
        double amount,
        Account origin,
        Account destination,
        int isFraud,
        int isFlaggedFraud) {
    public enum Type{
        CASH_IN, CASH_OUT, DEBIT, PAYMENT,TRANSFER;
    }


//    @Override
//    public String toString() {
//        return "step : " + step +
//                "\ntype : " + type +
//                "\namount : " + amount +
//                "\nnameOrig : " + origin.name() +
//                "\noldbalanceOrg : " + origin.oldBalance() +
//                "\nnewbalanceOrig : " + origin.newBalance() +
//                "\nnameDest : " + destination.name() +
//                "\noldbalanceDest : " + destination.oldBalance() +
//                "\nnewbalanceDest : " + destination.newBalance() +
//                "\nisFraud : " + isFraud +
//                "\nisFlaggedFraud : " + isFlaggedFraud;
//    }
}
