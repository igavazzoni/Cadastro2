/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexaoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class ConexaoPostgres {
    private static final String DRIVER = "org.postgres.Driver";
    private static final String URL = "jdbc:postgres://localhost:5432/Uniparbd";
    private static final String USER = "postgres";
    private static final String PASSWORD = "unipar";
    
    //abrir conexão com o BD
    public static Connection getConection(){

        try {
            Class.forName(DRIVER);
            
            return DriverManager.getConnection(URL,USER, PASSWORD);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoPostgres.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoPostgres.class.getName()).log(Level.SEVERE, null, ex);
        }
     return null;   
    }
    
    //fechar conexão
    
    public static void closeConnection(Connection conn){
        if(conn != null){
            try{
               conn.close(); 
            }catch(SQLException ex){
                Logger.getLogger(ConexaoPostgres.class.getName()).log(Level.SEVERE,null, ex);
            }
        }
    }
    public static void closeTransaction(Connection conn, PreparedStatement ps){
        if(ps != null){
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoPostgres.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        closeConnection(conn);
    }
}
