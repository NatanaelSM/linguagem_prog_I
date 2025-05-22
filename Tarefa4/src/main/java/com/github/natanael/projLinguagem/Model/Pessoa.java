package com.github.natanael.projLinguagem.Model;

public class Pessoa {

    private String sexo;
    private double altura;
    private String tipoSanguineo;

    public Pessoa(String sexo, double altura, String tipoSanguineo) {
        this.sexo = sexo;
        this.altura = altura;
        this.tipoSanguineo = tipoSanguineo;
    }

    public String comer() {
        return "A pessoa está comendo.";
    }

    public String correr() {
        return "A pessoa está correndo.";
    }

    public String levantar() {
        return "A pessoa se levantou.";
    }
}