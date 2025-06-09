package com.github.natanael.projlinguagem.model;

public class Carro {

	private int id;
	private String marca;
	private String modelo;
	private int ano;

	public Carro() {}

	public Carro (int id, String modelo, String marca, int ano) {
		this.id = id;
		this.modelo = modelo;
		this.marca = marca;
		this.ano = ano;
	}

	public Carro (String modelo, String marca, int ano) {
		this.modelo = modelo;
		this.marca = marca;
		this.ano = ano;
	}

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//	public String ligar () {
//		return "O " + modelo + " da marca " + marca + " e ano " + ano + " ligou!";
//	}
//
//	public String desligar () {
//		return "O " + modelo + " da marca " + marca + " e ano " + ano + " desligou!";
//	}
//
//	public String buzinar () {
//		return "O " + modelo + " da marca " + marca + " e ano " + ano + " buzinou!";
//	}
	
}