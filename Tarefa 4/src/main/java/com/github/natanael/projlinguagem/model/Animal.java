package com.github.natanael.projlinguagem.model;

public class Animal {

    private int id;
    private String raca;
    private Boolean extinto;
    private String nome;

    public Animal (String raca, Boolean extinto, String nome) {
        this.raca = raca;
        this.extinto = extinto;
        this.nome = nome;

    }

    public Animal(int id, String raca, Boolean extinto, String nome) {
        this.id = id;
        this.raca = raca;
        this.extinto = extinto;
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Boolean getExtinto() {
        return extinto;
    }

    public void setExtinto(Boolean extinto) {
        this.extinto = extinto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
