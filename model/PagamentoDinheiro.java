package model;

public class PagamentoDinheiro implements Pagamento {
    @Override
    public void processarPagamento(double valor) {
        System.out.println("Pagamento de R$" + String.format("%.2f", valor) + " realizado em dinheiro.");
    }

    @Override
    public String getTipoPagamento() {
        return "Dinheiro";
    }
}
