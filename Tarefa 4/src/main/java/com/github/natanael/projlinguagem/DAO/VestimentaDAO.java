package com.github.natanael.projlinguagem.DAO;

import com.github.natanael.projlinguagem.model.Vestimenta;
import com.github.natanael.projlinguagem.util.ConexaoBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VestimentaDAO {
    private Connection conexao;

    public VestimentaDAO() {
        conexao = ConexaoBD.getConexao();
    }

    public boolean cadastrar(Vestimenta vestimenta) {
        String sql = "INSERT INTO vestimenta (tipo, unidades, preco) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, vestimenta.getTipo());
            stmt.setInt(2, vestimenta.getUnidades());
            stmt.setDouble(3, vestimenta.getPreco());
            stmt.execute();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                vestimenta.setId(rs.getInt(1));
            }

            stmt.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<Vestimenta> listar() {
        List<Vestimenta> vestimentas = new ArrayList<>();
        String sql = "SELECT * FROM vestimenta";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                vestimentas.add(new Vestimenta(
                        rs.getInt("id"),
                        rs.getString("tipo"),
                        rs.getInt("unidades"),
                        rs.getDouble("preco")
                ));
            }

            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return vestimentas;
    }

    public boolean atualizar(Vestimenta vestimenta) {
        String sql = "UPDATE vestimenta SET tipo = ?, unidades = ?, preco = ? WHERE id = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, vestimenta.getTipo());
            stmt.setInt(2, vestimenta.getUnidades());
            stmt.setDouble(3, vestimenta.getPreco());
            stmt.setInt(4, vestimenta.getId());
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean deletar(int id) {
        String sql = "DELETE FROM vestimenta WHERE id = ?";
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
