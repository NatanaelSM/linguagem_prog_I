package com.github.natanael.projlinguagem.DAO;

import com.github.natanael.projlinguagem.Util.ConexaoBD;
import com.github.natanael.projlinguagem.model.Animal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AnimalDAO {

    private Connection conexao;

    public AnimalDAO() {
        conexao = ConexaoBD.getConexao();
    }

    public Boolean cadastrar(Animal animal) {
        String sql = "INSERT INTO animal(nome, raca, extinto) VALUES (?,?,?)";

        try{
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, animal.getNome());
            stmt.setString(2, animal.getRaca());
            stmt.setBoolean(3, animal.getExtinto());
            stmt.execute();
            return true;

        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }

}
