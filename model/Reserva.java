package model;

import java.time.LocalDateTime;

public class Reserva {
    private Campo campo;
    private LocalDateTime horarioInicio;
    private int duracaoHoras;
    private String cliente;
    private Pagamento pagamento;

    public Reserva(Campo campo, LocalDateTime horarioInicio, int duracaoHoras, String cliente, Pagamento pagamento) {
        this.campo = campo;
        this.horarioInicio = horarioInicio;
        this.duracaoHoras = duracaoHoras;
        this.cliente = cliente;
        this.pagamento = pagamento;
    }

    public Campo getCampo() {
        return campo;
    }

    public LocalDateTime getHorarioInicio() {
        return horarioInicio;
    }

    public int getDuracaoHoras() {
        return duracaoHoras;
    }

    public String getCliente() {
        return cliente;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public double calcularValorTotal() {
        return campo.getPrecoPorHora() * duracaoHoras;
    }

    public void realizarPagamento() {
        double valorTotal = calcularValorTotal();
        pagamento.processarPagamento(valorTotal);
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "campo=" + campo.getNome() +
                ", horarioInicio=" + horarioInicio +
                ", duracaoHoras=" + duracaoHoras +
                ", cliente='" + cliente + '\'' +
                ", pagamento=" + pagamento.getTipoPagamento() +
                ", valorTotal=R$" + String.format("%.2f", calcularValorTotal()) +
                '}';
    }
}
