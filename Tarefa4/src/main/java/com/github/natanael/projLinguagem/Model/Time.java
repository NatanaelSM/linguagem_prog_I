package com.github.natanael.projLinguagem.Model;

public class Time {

	private String nome;
	private int numJogadores;
	private String estado;
	
	public Time (String nome, int numJogadores, String estado) {
		this.nome = nome;
		this.numJogadores = numJogadores;
		this.estado = estado;
	}
	
	public String jogar (String timeRival) {
		return "O time " + nome + " está jogando!";
	}
	
	public String comprarJogador () {
		return "O time " + nome + " comprou um jogador!";
	}
	
	public String venderJogador () {
		return "O time " + nome + " vendeu um jogador!";
	}
	
}
