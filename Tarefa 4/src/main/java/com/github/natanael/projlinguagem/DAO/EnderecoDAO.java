package com.github.natanael.projlinguagem.DAO;

import com.github.natanael.projlinguagem.model.Endereco;
import com.github.natanael.projlinguagem.util.ConexaoBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAO {
    private Connection conexao = ConexaoBD.getConexao();

    public boolean cadastrar(Endereco endereco) {
        String sql = "INSERT INTO endereco (rua, numero, bairro) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, endereco.getRua());
            stmt.setInt(2, endereco.getNumero());
            stmt.setString(3, endereco.getBairro());
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) endereco.setId(rs.getInt(1));
            stmt.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean atualizar(Endereco endereco) {
        String sql = "UPDATE endereco SET rua = ?, numero = ?, bairro = ? WHERE id = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, endereco.getRua());
            stmt.setInt(2, endereco.getNumero());
            stmt.setString(3, endereco.getBairro());
            stmt.setInt(4, endereco.getId());
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean deletar(int id) {
        String sql = "DELETE FROM endereco WHERE id = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<Endereco> listar() {
        List<Endereco> enderecos = new ArrayList<>();
        String sql = "SELECT * FROM endereco";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Endereco e = new Endereco(
                        rs.getInt("id"),
                        rs.getString("rua"),
                        rs.getInt("numero"),
                        rs.getString("bairro")
                );
                enderecos.add(e);
            }
            stmt.close();
            return enderecos;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
