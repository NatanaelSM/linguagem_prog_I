package com.github.natanael.projlinguagem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

    public static Connection getConexao() {

        //Endereço do BD mysql
        String url = "jdbc:mysql://localhost:3306/banco_projlinguagem";
        String usuario = "root";
        String senha = "12345";

        try {

            // Carrega o driver JDBC e registra automaticamente no "DriverManager"
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Realiza a conexão com o banco de dados
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            return conexao;

        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao conectar no banco de dados");
            return null;
        } catch (SQLException e) {
            System.out.println("Erro nos dados de acesso ao banco de dados");
            return null;
        }
    }

}