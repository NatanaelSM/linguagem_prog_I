package com.github.natanael.projLinguagem.Model;

public class Piloto {

    private String escuderia;
    private double salario;
    private String paisOrigem;

    public Piloto(String escuderia, double salario, String paisOrigem) {
        this.escuderia = escuderia;
        this.salario = salario;
        this.paisOrigem = paisOrigem;
    }

    public String aumentarSalario(double percentual) {
        this.salario += this.salario * (percentual / 100);
        return "O salário foi aumentado para: " + salario;
    }

    public String correr() {
        return "O piloto da escuderia " + escuderia + " está correndo!";
    }

    public String trocarEscuderia(String novaEscuderia) {
        this.escuderia = novaEscuderia;
        return "O piloto mudou para a escuderia: " + escuderia;
    }
}

