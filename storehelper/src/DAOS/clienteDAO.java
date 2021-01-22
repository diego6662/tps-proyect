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


public class clienteDAO {
    
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
    
    /*no funcional
    public int contarClientes(){
        int cantidad=0;
        try { 
        
            String sentenciaSQL = new String();
            sentenciaSQL = "SELECT count(*) from Clientes";
            PreparedStatement declaracion = conexion.prepareStatement(sentenciaSQL);
            
            int registro = declaracion.executeUpdate();
            System.out.println("registro: "+registro);
            if(registro > 0) {
                    JOptionPane.showMessageDialog(null, "consultado");
            }
        
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error consultando xd "+ e);
    }
        
        return cantidad;
        
    }*/
    
    /*no funcional
    public List ConsultarTodosLosClientes() {
    
        List lista = new ArrayList();
    try {
    Statement ejecutor = conexion.createStatement();
    ResultSet respuesta = ejecutor.executeQuery("select * from Clientes");
    while (respuesta.next()) {
                            
        
            lista.add(respuesta.getInt("cedula"));
            lista.add(respuesta.getString("nombre"));
            lista.add(respuesta.getString("telefono"));
            lista.add(respuesta.getString("direccion"));                
    }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "error al consultar todos los clientes"+ e);
            }
    return lista;
    } */
    public void Crear(int Cedula, String Nombre, int Telefono, String Direccion ) {
	
	try {
            String sentenciaSQL = new String();
            sentenciaSQL = "INSERT INTO Clientes(cedula, nombre, telefono, direccion) VALUES (?,?,?,?)";
            PreparedStatement declaracion = conexion.prepareStatement(sentenciaSQL);
            
            declaracion.setInt(1, Cedula);
            declaracion.setString(2, Nombre);
            declaracion.setInt(3, Telefono);
            declaracion.setString(4, Direccion);
            
            int registro = declaracion.executeUpdate();
            if(registro > 0) {
        	JOptionPane.showMessageDialog(null, "Cliente Registrado");
            }
        
    } catch (Exception e) {
    	    JOptionPane.showMessageDialog(null, "error creando"+ e);
            //System.out.println("Error: "+ e);
	}
    }
    
    public void Modificar(int Cedula, String Nombre, int Telefono, String Direccion) {
	
	try { 
		
            String sentenciaSQL = new String();
            sentenciaSQL = "UPDATE Clientes SET nombre = ?, telefono = ?, direccion = ? WHERE cedula = ?";
            PreparedStatement declaracion = conexion.prepareStatement(sentenciaSQL);
            
            declaracion.setInt(4, Cedula);
            declaracion.setString(1, Nombre);
            declaracion.setInt(2, Telefono);
            declaracion.setString(3, Direccion);
            
            int registro = declaracion.executeUpdate();
            if(registro > 0) {
                    JOptionPane.showMessageDialog(null, "Guardado");
            }
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error modificando"+ e);
	}
    }
    
    public int Eliminar(int Cedula) {
	 
        int re=0;
 
        try {
            Statement ejecutor = conexion.createStatement();


            ResultSet respuesta = ejecutor.executeQuery("Delete from Clientes where cedula ='" + Cedula +"'");

            if (respuesta.next()) {

                    re = 1;			
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al eliminar"+ e);
        }

        return re;
    }
    
}
