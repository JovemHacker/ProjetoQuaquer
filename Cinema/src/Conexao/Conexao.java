/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ifsp
 */
public class Conexao {
    
    public Connection getConexao()
    {
        try {
            //jdbc = Java Database Conector
            return DriverManager.
                    getConnection("jdbc:mysql://localhost/cinema", "root", "");
        } catch (Exception e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }
    
}
