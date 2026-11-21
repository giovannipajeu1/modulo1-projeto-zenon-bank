package br.com.zenon.fraud;

public record Account(String name, double oldBalance, double newBalance) {
    private static Object validaSeNulo(Object transaction){
        if(transaction == null){
            throw  new IllegalArgumentException("Campos não podem ser nulos");
        }
        return transaction;
    }
    private static double validaSeNegativo(double valor){
        if(valor <0){
            throw new IllegalArgumentException("Valor nao pode ser negativo");
        } return valor;
    }
    private static String validaSeNomeVazio(String nome){
        if(nome.isEmpty()){
            throw  new IllegalArgumentException( " O nome nao pode ser vazio");
        } return  nome;
    }

    public Account{
        validaSeNulo(name);
        validaSeNomeVazio(name);
        validaSeNegativo(oldBalance);
        validaSeNegativo(newBalance);
    }
}
