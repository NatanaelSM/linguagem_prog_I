package com.github.natanael.projlinguagem.model;

public class Pessoa {

    private int id;
    private String sexo;
    private double altura;
    private String tipoSanguineo;

    public Pessoa() {
    }

    public Pessoa(String sexo, double altura, String tipoSanguineo) {
        this.sexo = sexo;
        this.altura = altura;
        this.tipoSanguineo = tipoSanguineo;
    }

    public Pessoa(int id, String sexo, double altura, String tipoSanguineo) {
        this.id = id;
        this.sexo = sexo;
        this.altura = altura;
        this.tipoSanguineo = tipoSanguineo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }
}