package com.github.natanael.projlinguagem.DAO;

import com.github.natanael.projlinguagem.model.Carro;
import com.github.natanael.projlinguagem.util.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarroDAO {

    private Connection conexao;

    public CarroDAO() {
        conexao = ConexaoBD.getConexao();
    }

    public Boolean cadastrar(Carro carro) {
        String sql = "INSERT INTO carro(marca, modelo, ano) VALUES (?,?,?)";

        try{
            PreparedStatement stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, carro.getMarca());
            stmt.setString(2, carro.getModelo());
            stmt.setInt(3, carro.getAno());
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                int idGerado = rs.getInt(1);
                carro.setId(idGerado);
            }
            stmt.close();

            return true;

        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public Boolean deletar(int id) {
        String sql = "DELETE FROM carro WHERE id = ?";

        try{
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            return true;

        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public List<Carro> listar() {

        String sql = "SELECT * FROM carro";
        List<Carro> carros = new ArrayList<>();

        try{
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                int ano = rs.getInt("ano");
                Carro carro = new Carro(id ,modelo, marca, ano);
                carros.add(carro);
            }

            stmt.execute();
            stmt.close();
            return carros;

        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public boolean atualizar(Carro carro) {
        String sql = "UPDATE carro SET marca = ?, modelo = ?, ano = ? WHERE id = ?";

        try{
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, carro.getMarca());
            stmt.setString(2, carro.getModelo());
            stmt.setInt(3, carro.getAno());
            stmt.setInt(4, carro.getId());

            stmt.execute();
            stmt.close();
            return true;

        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            return false;
        }

    }



}
