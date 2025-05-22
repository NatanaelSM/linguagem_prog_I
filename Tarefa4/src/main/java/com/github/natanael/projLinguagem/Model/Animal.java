package com.github.natanael.projLinguagem.Model;

public class Animal {

	private String raca;
	private Boolean extinto;
	private String dieta;
	
	public Animal (String raca, Boolean extinto, String dieta) {
		this.raca = raca;
		this.extinto = extinto;
		this.dieta = dieta;
	}
	
	public String comer () {
		return "O " + raca + " de dieta " + dieta + " comeu!";
	}
	
	public String emitirSom () {
		return "O " + raca + " de dieta " + dieta + " emitiu som!";
	}
	
	public String mover () {
		return "O " + raca + " de dieta " + dieta + " moveu!";
	}
	
}
