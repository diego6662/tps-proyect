/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class Conexion {
    String url = "storehelperdb.db";
    Connection conexion;
    
    
    public void conectar(){
        try {
            Class.forName("org.sqlite.JDBC");
            conexion=DriverManager.getConnection("jdbc:sqlite:"+url);
            if (conexion!=null){
                System.out.println("conexion correctaaaaaaa");
                
            }
        } catch (SQLException e) {
            
                System.out.println("conexion mal");
                
        } catch (ClassNotFoundException ex) {
                System.out.println("conexion peor");
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void desconectar(){
        try {
            conexion.close();
            System.out.println("conexion cerrada correctamente");
            
        } catch (SQLException e) {
            System.out.println("Fallo al cerrar la conessssion");
            
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
}
