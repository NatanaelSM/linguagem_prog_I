package com.github.natanael.projLinguagem.Model;

public class Carro {

	private String marca;
	private String modelo;
	private int ano;
	
	public Carro (String modelo, String marca, int ano) {
		this.modelo = modelo;
		this.marca = marca;
		this.ano = ano;
	}
	
	public String ligar () {
		return "O " + modelo + " da marca " + marca + " e ano " + ano + " ligou!";
	}
	
	public String desligar () {
		return "O " + modelo + " da marca " + marca + " e ano " + ano + " desligou!";
	}
	
	public String buzinar () {
		return "O " + modelo + " da marca " + marca + " e ano " + ano + " buzinou!";
	}
	
}