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


}
