package model;

public interface Pagamento {
    void processarPagamento(double valor);
    String getTipoPagamento();
}
