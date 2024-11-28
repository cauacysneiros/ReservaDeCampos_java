package service;

import model.Campo;
import model.Pagamento;
import model.Reserva;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GestorCampo {
    private List<Campo> campos = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();

    public void cadastrarCampo(Campo campo) {
        campos.add(campo);
    }

    public List<Campo> getCampos() {
        return campos;
    }

    public boolean reservarCampo(String nomeCampo, LocalDateTime horarioInicio, int duracaoHoras, String cliente, Pagamento pagamento) {
        for (Campo campo : campos) {
            if (campo.getNome().equalsIgnoreCase(nomeCampo)) {
                Reserva reserva = new Reserva(campo, horarioInicio, duracaoHoras, cliente, pagamento);
                reservas.add(reserva);
                reserva.realizarPagamento();
                return true;
            }
        }
        return false;
    }

    public List<Reserva> consultarReservas() {
        return reservas;
    }
}
