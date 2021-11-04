/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
public class UsuarioDAO {
    private Conexao conexao;
    private Connection conn;

    public UsuarioDAO() {
        this.conexao = new Conexao();
        this.conn = conexao.getConexao();
    }
    
    public boolean autenticar(Usuario u){
        String sql = "SELECT * FROM usuario WHERE usuario = ? AND senha = ?";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, u.getUsuario());
            stmt.setString(2, u.getSenha());
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                //Acrescenta as informacoes id e nome para que possam ser usadas
                //no form principal, por exemplo.
                u.setId(rs.getInt("id"));
                u.setUsuario(rs.getString("usuario"));
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
        public void inserir(Usuario u) throws Exception
        {
            String sql = "INSERT INTO usuario(usuario, senha) VALUES (?, ?)";

            try {
                PreparedStatement stmt = this.conn.prepareStatement(sql);
                stmt.setString(1, u.getUsuario());
                stmt.setString(2, u.getSenha());
                stmt.execute();
            } catch (Exception e) {
                throw new Exception("Erro ao salvar usuario: " + e.getMessage());
            }
        }
        
        public void editar(Usuario u) throws Exception
        {
            String sql = "UPDATE usuario SET usuario = ?, senha = ? WHERE id = ?";

            try {
                PreparedStatement stmt = this.conn.prepareStatement(sql);
                stmt.setString(1, u.getUsuario());
                stmt.setString(2, u.getSenha());
                stmt.setInt(3, u.getId());
                stmt.execute();
            } catch (Exception e) {
                throw new Exception("Erro ao editar usuario: " + e.getMessage());
            }
        }
        public void excluir(Usuario u) throws Exception
        {
            String sql = "DELETE FROM usuario WHERE id = ?";

            try {
                PreparedStatement stmt = this.conn.prepareStatement(sql);
                stmt.setInt(1, u.getId());
                stmt.execute();
            } catch (Exception e) {
                throw new Exception("Erro ao excluir usuario: " + e.getMessage());
            }
        }
        
        public List<Usuario> getUsuario(String Usuario) throws Exception
        {
            String sql = "SELECT * FROM usuario WHERE usuario LIKE ?";

            try {
                PreparedStatement stmt = this.conn.prepareStatement(sql);
                stmt.setString(1, "%" + Usuario + "%");
                ResultSet rs = stmt.executeQuery();
                List<Usuario> lista = new ArrayList<>();

                while(rs.next()){
                    Usuario c = new Usuario();
                    c.setId(rs.getInt("id"));
                    c.setUsuario(rs.getString("usuario"));
                    lista.add(c);
                }
                return lista;
            } catch (Exception e) {
                throw new Exception("Erro ao buscar usuario");
            }
        }
        public Usuario getUsuarioById(int id) throws Exception
        {
            String sql = "SELECT * FROM usuario WHERE id = ?";

            try {
                PreparedStatement stmt = this.conn.prepareStatement(sql);
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                rs.first();
                Usuario cli = new Usuario();
                cli.setId(rs.getInt("id"));
                cli.setUsuario(rs.getString("usuario"));
                cli.setSenha(rs.getString("senha"));
                return cli;
            } catch (Exception e) {
                throw new Exception("Usuario não encontrado");
            }
        } 
        
    
    
}
