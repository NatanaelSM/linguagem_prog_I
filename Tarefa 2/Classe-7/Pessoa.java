package testando;

import java.util.Date;

public class Carro {

	private String nome;
	private Date dataCriacao;
	private String estado;
	
	public Carro (String nome) {
		this.nome = nome;
	}
	
	public void jogar (String timeRival) {
		System.out.println("O time " + nome + " está jogando!");
	}
	
	public void comprarJogador () {
		System.out.println("O time " + nome + a" comprou um jogador!");
	}
	
	public void venderJogador () {
		System.out.println("O time " + nome + " vendeu um jogador!");
	}
	
}
