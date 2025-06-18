package com.github.natanael.projlinguagem.DAO;

import com.github.natanael.projlinguagem.model.Pessoa;
import com.github.natanael.projlinguagem.util.ConexaoBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {

    private Connection conexao;

    public PessoaDAO() {
        conexao = ConexaoBD.getConexao();
    }

    public boolean cadastrar(Pessoa pessoa) {
        String sql = "INSERT INTO pessoa (sexo, altura, tipo_sanguineo) VALUES (?, ?, ?)";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, pessoa.getSexo());
            stmt.setDouble(2, pessoa.getAltura());
            stmt.setString(3, pessoa.getTipoSanguineo());
            stmt.execute();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                pessoa.setId(rs.getInt(1));
            }

            stmt.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean deletar(int id) {
        String sql = "DELETE FROM pessoa WHERE id = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public List<Pessoa> listar() {
        List<Pessoa> pessoas = new ArrayList<>();
        String sql = "SELECT * FROM pessoa";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Pessoa p = new Pessoa(
                        rs.getInt("id"),
                        rs.getString("sexo"),
                        rs.getDouble("altura"),
                        rs.getString("tipo_sanguineo")
                );
                pessoas.add(p);
            }

            stmt.close();
            return pessoas;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public boolean atualizar(Pessoa pessoa) {
        String sql = "UPDATE pessoa SET sexo = ?, altura = ?, tipo_sanguineo = ? WHERE id = ?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, pessoa.getSexo());
            stmt.setDouble(2, pessoa.getAltura());
            stmt.setString(3, pessoa.getTipoSanguineo());
            stmt.setInt(4, pessoa.getId());

            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}