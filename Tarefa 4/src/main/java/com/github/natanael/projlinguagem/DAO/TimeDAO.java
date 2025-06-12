package com.github.natanael.projlinguagem.DAO;

import com.github.natanael.projlinguagem.model.Time;
import com.github.natanael.projlinguagem.util.ConexaoBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TimeDAO {

    private Connection conexao;

    public TimeDAO() {
        conexao = ConexaoBD.getConexao();
    }

    public boolean cadastrar(Time time) {
        String sql = "INSERT INTO time (nome, numJogadores, estado) VALUES (?, ?, ?)";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, time.getNome());
            stmt.setInt(2, time.getNumJogadores());
            stmt.setString(3, time.getEstado());
            stmt.execute();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                time.setId(rs.getInt(1));
            }

            stmt.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean deletar(int id) {
        String sql = "DELETE FROM time WHERE id = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public List<Time> listar() {
        List<Time> times = new ArrayList<>();
        String sql = "SELECT * FROM time";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Time t = new Time(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("numJogadores"),
                        rs.getString("estado")
                );
                times.add(t);
            }

            stmt.close();
            return times;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public boolean atualizar(Time time) {
        String sql = "UPDATE time SET nome = ?, numJogadores = ?, estado = ? WHERE id = ?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, time.getNome());
            stmt.setInt(2, time.getNumJogadores());
            stmt.setString(3, time.getEstado());
            stmt.setInt(4, time.getId());
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
