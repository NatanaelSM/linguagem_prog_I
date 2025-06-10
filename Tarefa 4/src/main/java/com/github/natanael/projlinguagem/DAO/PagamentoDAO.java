package com.github.natanael.projlinguagem.DAO;

import com.github.natanael.projlinguagem.model.Pagamento;
import com.github.natanael.projlinguagem.util.ConexaoBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PagamentoDAO {
    private Connection conexao;

    public PagamentoDAO() {
        conexao = ConexaoBD.getConexao();
    }

    public boolean cadastrar(Pagamento pagamento) {
        String sql = "INSERT INTO pagamento (valor, formaPagamento, parcelas) VALUES (?, ?, ?)";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setDouble(1, pagamento.getValor());
            stmt.setString(2, pagamento.getFormaPagamento());
            stmt.setInt(3, pagamento.getParcelas());
            stmt.execute();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                pagamento.setId(rs.getInt(1));
            }

            stmt.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean deletar(int id) {
        String sql = "DELETE FROM pagamento WHERE id = ?";
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

    public List<Pagamento> listar() {
        List<Pagamento> pagamentos = new ArrayList<>();
        String sql = "SELECT * FROM pagamento";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Pagamento p = new Pagamento(
                        rs.getInt("id"),
                        rs.getDouble("valor"),
                        rs.getString("formaPagamento"),
                        rs.getInt("parcelas")
                );
                pagamentos.add(p);
            }

            stmt.close();
            return pagamentos;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public boolean atualizar(Pagamento pagamento) {
        String sql = "UPDATE pagamento SET valor = ?, formaPagamento = ?, parcelas = ? WHERE id = ?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setDouble(1, pagamento.getValor());
            stmt.setString(2, pagamento.getFormaPagamento());
            stmt.setInt(3, pagamento.getParcelas());
            stmt.setInt(4, pagamento.getId());

            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
