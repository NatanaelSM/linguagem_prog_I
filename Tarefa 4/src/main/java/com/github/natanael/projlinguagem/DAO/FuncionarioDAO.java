package com.github.natanael.projlinguagem.DAO;

import com.github.natanael.projlinguagem.model.Funcionario;
import com.github.natanael.projlinguagem.util.ConexaoBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    private Connection conexao;

    public FuncionarioDAO() {
        conexao = ConexaoBD.getConexao();
    }

    public boolean cadastrar(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario (nome, salario, sexo) VALUES (?, ?, ?)";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, funcionario.getNome());
            stmt.setDouble(2, funcionario.getSalario());
            stmt.setString(3, funcionario.getSexo());
            stmt.execute();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                funcionario.setId(rs.getInt(1));
            }

            stmt.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean deletar(int id) {
        String sql = "DELETE FROM funcionario WHERE id = ?";
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

    public List<Funcionario> listar() {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM funcionario";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario f = new Funcionario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("salario"),
                        rs.getString("sexo")
                );
                funcionarios.add(f);
            }

            stmt.close();
            return funcionarios;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public boolean atualizar(Funcionario funcionario) {
        String sql = "UPDATE funcionario SET nome = ?, salario = ?, sexo = ? WHERE id = ?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setDouble(2, funcionario.getSalario());
            stmt.setString(3, funcionario.getSexo());
            stmt.setInt(4, funcionario.getId());

            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
