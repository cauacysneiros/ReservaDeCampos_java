package model;

public class PagamentoCartao implements Pagamento {
    private String tipoCartao; // "Crédito" ou "Débito"

    public PagamentoCartao(String tipoCartao) {
        this.tipoCartao = tipoCartao;
    }

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Pagamento de R$" + String.format("%.2f", valor) + " realizado no cartão (" + tipoCartao + ").");
    }

    @Override
    public String getTipoPagamento() {
        return tipoCartao;
    }
}
