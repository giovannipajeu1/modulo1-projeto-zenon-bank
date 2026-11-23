package br.com.zenon.fraud;


public record Transaction(
/*
nenhum valor pode ser nulo, validaseNulo()
step deve ser maior ou igual a 1,
outros números não podem ser negativos mas podem ser zero.
Os valores de type devem ser os definidos anteriormente.
*/
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

    private static Object validaSeNulo(Object transaction){
        if(transaction == null){
            throw  new IllegalArgumentException("Campos não podem ser nulos");
        }
            return transaction;
    }

    private static double validaSeNegativos(double valor){
        if(valor < 0){
            throw  new IllegalArgumentException("O valor nao pode ser menor que zero");
        }
        return valor;
    }
    private static int validaStep(int step){
        if(step <=0){
            throw  new IllegalArgumentException("O valor precisa ser maior ou igual a 1");
        }
        return step;
    }
    public Transaction{
        validaSeNulo(type);
        validaSeNulo(origin);
        validaSeNulo(destination);
        validaStep(step);
        validaSeNegativos(amount);
        validaSeNegativos(isFraud);
        validaSeNegativos(isFlaggedFraud);

    }


}
