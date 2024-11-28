package model;

public class PagamentoPix implements Pagamento {
    @Override
    public void processarPagamento(double valor) {
        System.out.println("Pagamento de R$" + String.format("%.2f", valor) + " realizado via PIX.");
    }

    @Override
    public String getTipoPagamento() {
        return "PIX";
    }
}
