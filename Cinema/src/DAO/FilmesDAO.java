/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Filmes;
import Beans.Usuario;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ifsp
 */
public class FilmesDAO {
    private Conexao conexao;
    private Connection conn;

    public FilmesDAO() {
        this.conexao = new Conexao();
        this.conn = conexao.getConexao();
    }
    
     public void inserir(Filmes f) throws Exception
        {
            String sql = "INSERT INTO filme(nomeoriginal, nome, genero, duracao, restricaoidade, sinopse) VALUES (?, ?, ?, ?, ?, ?)";

            try {
                PreparedStatement stmt = this.conn.prepareStatement(sql);
                stmt.setString(1, f.getNomeoriginal());
                stmt.setString(2, f.getNome());
                stmt.setString(3, f.getGenero());
                stmt.setString(4, f.getDuracao());
                stmt.setInt(5, f.getRestricaoidade());
                stmt.setString(6, f.getSinopse());
                stmt.execute();
            } catch (Exception e) {
                throw new Exception("Erro ao salvar usuario: " + e.getMessage());
            }
        }
     
     public void editar(Filmes f) throws Exception
        {
            String sql = "UPDATE filme SET nomeoriginal = ?, nome = ?, genero = ?, duracao = ?, restricaoidade = ?, sinopse = ? WHERE id = ?";

            try {
                PreparedStatement stmt = this.conn.prepareStatement(sql);
                stmt.setString(1, f.getNomeoriginal());
                stmt.setString(2, f.getNome());
                stmt.setString(3, f.getGenero());
                stmt.setString(4, f.getDuracao());
                stmt.setInt(5, f.getRestricaoidade());
                stmt.setString(6, f.getSinopse());
                stmt.setInt(7, f.getId());
                stmt.execute();
            } catch (Exception e) {
                throw new Exception("Erro ao editar usuario: " + e.getMessage());
            }
        }
     
     public void excluir(Filmes f) throws Exception
        {
            String sql = "DELETE FROM filme WHERE id = ?";

            try {
                PreparedStatement stmt = this.conn.prepareStatement(sql);
                stmt.setInt(1, f.getId());
                stmt.execute();
            } catch (Exception e) {
                throw new Exception("Erro ao excluir usuario: " + e.getMessage());
            }
        }
     
     public List<Filmes> getFilme(String Nome) throws Exception
        {
            String sql = "SELECT * FROM filme WHERE nome LIKE ?";

            try {
                PreparedStatement stmt = this.conn.prepareStatement(sql);
                stmt.setString(1, "%" + Nome + "%");
                ResultSet rs = stmt.executeQuery();
                List<Filmes> lista = new ArrayList<>();

                while(rs.next()){
                    Filmes f = new Filmes();
                    f.setId(rs.getInt("id"));
                    f.setNomeoriginal(rs.getString("nomeoriginal"));
                    f.setNome(rs.getString("nome"));
                    f.setGenero(rs.getString("genero"));
                    f.setDuracao(rs.getString("duracao"));
                    f.setRestricaoidade(rs.getInt("restricaoidade"));
                    f.setSinopse(rs.getString("sinopse"));
                    lista.add(f);
                }
                return lista;
            } catch (Exception e) {
                throw new Exception("Erro ao buscar usuario");
            }
        }
     
     
     
     
}
