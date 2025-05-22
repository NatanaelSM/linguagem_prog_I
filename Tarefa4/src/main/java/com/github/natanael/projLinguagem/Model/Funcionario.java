package com.github.natanael.projLinguagem.Model;

public class Funcionario {

	private String nome;
	private double salario;
	private String sexo;
	
	public Funcionario (String nome, double salario, String sexo) {
		this.nome = nome;
		this.salario = salario;
		this.sexo = sexo;
	}
	
	public String entrarEmServico () {
		return "O " + nome + " do sexo " + sexo + " e salário " + salario + " entrou em serviço!";
	}
	
	public String almocar () {
		return "O " + nome + " do sexo " + sexo + " e salário " + salario + " almoçou!";
	}
	
	public String aumentarSalario () {
		return "O " + nome + " do sexo " + sexo + " e salário " + salario + " aumentou o salário!";
	}
	
}
