package com.github.natanael.projlinguagem.DAO;

import com.github.natanael.projlinguagem.Util.ConexaoBD;
import com.github.natanael.projlinguagem.model.Animal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO {

    private Connection conexao;

    public AnimalDAO() {
        conexao = ConexaoBD.getConexao();
    }

    public Boolean cadastrar(Animal animal) {
        String sql = "INSERT INTO animal(nome, raca, extinto) VALUES (?,?,?)";

        try{
            PreparedStatement stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, animal.getNome());
            stmt.setString(2, animal.getRaca());
            stmt.setBoolean(3, animal.getExtinto());
            stmt.execute();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                System.out.println(rs);
                int idGerado = rs.getInt(1);
                animal.setId(idGerado); // Atualiza o objeto Animal com o ID
            }
            stmt.close();

            return true;

        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public Boolean deletar(int id) {
        String sql = "DELETE FROM animal WHERE id = ?";

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

    public List<Animal> listar() {

        String sql = "SELECT * FROM animal";
        List<Animal> animais = new ArrayList<>();

        try{
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String raca = rs.getString("raca");
                int extintoBinario = rs.getInt("extinto");
                Boolean extinto = (extintoBinario == 0) ? false : true;
                Animal animal = new Animal(id ,raca, extinto, nome);
                animais.add(animal);
            }

            stmt.execute();
            stmt.close();
            return animais;

        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

}
