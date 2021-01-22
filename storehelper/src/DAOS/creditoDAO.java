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


public class creditoDAO {
    
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
    
    public void Crear(Double deuda, int cedulaCliente, int idTransaccion) {
	
	try {
            String sentenciaSQL = new String();
            sentenciaSQL = "INSERT INTO Credito(deuda, cedulaCliente, idTransaccion) VALUES (?,?,?)";
            PreparedStatement declaracion = conexion.prepareStatement(sentenciaSQL);
            
            declaracion.setDouble(1, deuda);
            declaracion.setInt(2,  cedulaCliente);
            declaracion.setInt(3,  idTransaccion); 
            
            int registro = declaracion.executeUpdate();
            if(registro > 0) {
        	JOptionPane.showMessageDialog(null, "Credito Registrado");
            }
        
    } catch (Exception e) {
    	    JOptionPane.showMessageDialog(null, "error creando credito"+ e);
            //System.out.println("Error: "+ e);
	}
    }
    
    public void Modificar(int idCredito, Double deuda, int cedulaCliente, int idTransaccion) {
	
	try { 
		
            String sentenciaSQL = new String();
            sentenciaSQL = "UPDATE Credito SET deuda=?, cedulaCliente=?, idTransaccion=? WHERE idCredito = ?";
            PreparedStatement declaracion = conexion.prepareStatement(sentenciaSQL);
            
            declaracion.setInt(4, idCredito);
            declaracion.setDouble(1, deuda);
            declaracion.setInt(2,  cedulaCliente);
            declaracion.setInt(3,  idTransaccion); 
            
            int registro = declaracion.executeUpdate();
            if(registro > 0) {
                    JOptionPane.showMessageDialog(null, "Guardado");
            }
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error modificando credito"+ e);
	}
    }
    
    public int Eliminar(int idCredito) {
	 
        int re=0;
 
        try {
            Statement ejecutor = conexion.createStatement();


            ResultSet respuesta = ejecutor.executeQuery("Delete from Credito where idCredito ='" + idCredito +"'");

            if (respuesta.next()) {

                    re = 1;			
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al eliminar credito: "+ e);
        }

        return re;
    }
    
}
