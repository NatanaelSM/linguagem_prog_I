package com.projeto.Endereco;

public class Endereco {

    private int numero;
    private String rua;
    private String bairro;

    public Endereco(String rua, int numero, String bairro) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
    }

    public String mudarEndereco() {
        return "Endereço atualizado para: " + rua + ", " + numero + " - " + bairro;
    }

    public String exibirEndereco() {
        return "Endereço: " + rua + ", " + numero + " - " + bairro;
    }
    
    public String getRua() {
        return rua;
    }
}
