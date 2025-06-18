package com.github.natanael.projlinguagem.DAO;

import com.github.natanael.projlinguagem.model.Piloto;
import com.github.natanael.projlinguagem.util.ConexaoBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PilotoDAO {
    private Connection conexao;

    public PilotoDAO() {
        conexao = ConexaoBD.getConexao();
    }

    public boolean cadastrar(Piloto piloto) {
        String sql = "INSERT INTO piloto (escuderia, salario, paisOrigem) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, piloto.getEscuderia());
            stmt.setDouble(2, piloto.getSalario());
            stmt.setString(3, piloto.getPaisOrigem());
            stmt.execute();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                piloto.setId(rs.getInt(1));
            }

            stmt.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<Piloto> listar() {
        List<Piloto> pilotos = new ArrayList<>();
        String sql = "SELECT * FROM piloto";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                pilotos.add(new Piloto(
                        rs.getInt("id"),
                        rs.getString("escuderia"),
                        rs.getDouble("salario"),
                        rs.getString("paisOrigem")
                ));
            }

            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return pilotos;
    }

    public boolean atualizar(Piloto piloto) {
        String sql = "UPDATE piloto SET escuderia = ?, salario = ?, paisOrigem = ? WHERE id = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, piloto.getEscuderia());
            stmt.setDouble(2, piloto.getSalario());
            stmt.setString(3, piloto.getPaisOrigem());
            stmt.setInt(4, piloto.getId());
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean deletar(int id) {
        String sql = "DELETE FROM piloto WHERE id = ?";
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
}
