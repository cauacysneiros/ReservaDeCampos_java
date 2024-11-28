package model;

public class Campo {
    private String nome;
    private double precoPorHora;

    public Campo(String nome, double precoPorHora) {
        this.nome = nome;
        this.precoPorHora = precoPorHora;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoPorHora() {
        return precoPorHora;
    }
}
