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


public class transaccionDAO {
    
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
    public void consultar(){
        
    }
    
    public void Crear(String tipoTransaccion, Double valorTransaccion, String FechaTransaccion, int cedulaCliente) {
	
	try {
            String sentenciaSQL = new String();
            sentenciaSQL = "INSERT INTO Transaccion(tipoTransaccion, valorTransaccion, FechaTransaccion, cedulaCliente) VALUES (?,?,?.?)";
            PreparedStatement declaracion = conexion.prepareStatement(sentenciaSQL);
            
            declaracion.setString(1, tipoTransaccion);
            declaracion.setDouble(2,  valorTransaccion); 
            declaracion.setString(3, FechaTransaccion);
            declaracion.setInt(4, cedulaCliente);
            
            
            int registro = declaracion.executeUpdate();
            if(registro > 0) {
        	JOptionPane.showMessageDialog(null, "transaccion Registrado");
            }
        
    } catch (Exception e) {
    	    JOptionPane.showMessageDialog(null, "error creando transaccion"+ e);
            //System.out.println("Error: "+ e);
	}
    }
    
    public void Modificar(int idTransaccion, String tipoTransaccion, Double valorTransaccion, String FechaTransaccion, int cedulaCliente) {
	
	try { 
		
            String sentenciaSQL = new String();
            sentenciaSQL = "UPDATE Transaccion SET tipoTransaccion?, valorTransaccionn?, FechaTransaccionn?, cedulaClienten? WHERE idTransaccion = ?";
            PreparedStatement declaracion = conexion.prepareStatement(sentenciaSQL);
            
            declaracion.setInt(5, idTransaccion);
            declaracion.setString(1, tipoTransaccion);
            declaracion.setDouble(2,  valorTransaccion); 
            declaracion.setString(3, FechaTransaccion);
            declaracion.setInt(4, cedulaCliente);
            
            int registro = declaracion.executeUpdate();
            if(registro > 0) {
                    JOptionPane.showMessageDialog(null, "Guardado");
            }
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error modificando transaccion"+ e);
	}
    }
    
    public int Eliminar(int idTransaccion) {
	 
        int re=0;
 
        try {
            Statement ejecutor = conexion.createStatement();


            ResultSet respuesta = ejecutor.executeQuery("Delete from Transaccion where idTransaccion ='" + idTransaccion +"'");

            if (respuesta.next()) {

                    re = 1;			
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al eliminar transaccion: "+ e);
        }

        return re;
    }
    
}
