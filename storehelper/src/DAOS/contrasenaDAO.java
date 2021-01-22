/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class contrasenaDAO {
    
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
            
                System.out.println("error sql : "+e);
                
        } catch (ClassNotFoundException ex) {
                System.out.println("error de clase : "+ex);
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    public void Modificar(String contrasena ) {
	
	try { 
		
            String sentenciaSQL = new String();
            sentenciaSQL = "UPDATE Contrasena SET contrasena=?";
            PreparedStatement declaracion = conexion.prepareStatement(sentenciaSQL);
            
            declaracion.setString(1, contrasena);
            
            int registro = declaracion.executeUpdate();
            if(registro > 0) {
                    JOptionPane.showMessageDialog(null, "contrasena cambiada");
            }
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error modificando contrasena"+ e);
	}
    }
     
    
}
