package com.github.natanael.projlinguagem.DAO;

import com.github.natanael.projlinguagem.model.Lutador;
import com.github.natanael.projlinguagem.util.ConexaoBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LutadorDAO {

    private Connection conexao;

    public LutadorDAO() {
        conexao = ConexaoBD.getConexao();
    }

    public boolean cadastrar(Lutador lutador) {
        String sql = "INSERT INTO lutador (nome, idade, altura) VALUES (?, ?, ?)";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, lutador.getNome());
            stmt.setInt(2, lutador.getIdade());
            stmt.setDouble(3, lutador.getAltura());
            stmt.execute();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                lutador.setId(rs.getInt(1));
            }

            stmt.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean deletar(int id) {
        String sql = "DELETE FROM lutador WHERE id = ?";
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

    public List<Lutador> listar() {
        List<Lutador> lutadores = new ArrayList<>();
        String sql = "SELECT * FROM lutador";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Lutador l = new Lutador(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getDouble("altura")
                );
                lutadores.add(l);
            }

            stmt.close();
            return lutadores;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public boolean atualizar(Lutador lutador) {
        String sql = "UPDATE lutador SET nome = ?, idade = ?, altura = ? WHERE id = ?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, lutador.getNome());
            stmt.setInt(2, lutador.getIdade());
            stmt.setDouble(3, lutador.getAltura());
            stmt.setInt(4, lutador.getId());

            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
