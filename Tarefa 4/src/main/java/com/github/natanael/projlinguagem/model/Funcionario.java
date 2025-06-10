package com.github.natanael.projlinguagem.model;

public class Funcionario {
    private int id;
    private String nome;
    private double salario;
    private String sexo;

    public Funcionario() {}

    public Funcionario(String nome, double salario, String sexo) {
        this.nome = nome;
        this.salario = salario;
        this.sexo = sexo;
    }

    public Funcionario(int id, String nome, double salario, String sexo) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
        this.sexo = sexo;
    }

    // Getters e setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }
}
