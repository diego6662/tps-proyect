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


public class productoDAO {
    
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
    
    public void Crear(String Nombre, int Cantidad, String Descripcion, String FechaCompra, Double PrecioCompra,
                        Double PrecioVenta, Double PrecioPromo, int Categoria) {
	
	try {
            String sentenciaSQL = new String();
            sentenciaSQL = "INSERT INTO Producto(nombreProducto, cantidadProducto, descripcionProducto, fechaCompra, precioCompra, precioVenta, precioPromo, idCategoria) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement declaracion = conexion.prepareStatement(sentenciaSQL);
            
            declaracion.setString(1, Nombre);
            declaracion.setInt(2,  Cantidad);
            declaracion.setString(3, Descripcion );
            declaracion.setString(4, FechaCompra );
            declaracion.setDouble(5,  PrecioCompra);
            declaracion.setDouble(6,PrecioVenta  );
            declaracion.setDouble(7, PrecioPromo );
            declaracion.setInt(8,Categoria  ); 
            
            int registro = declaracion.executeUpdate();
            if(registro > 0) {
        	JOptionPane.showMessageDialog(null, "Producto Registrado");
            }
        
    } catch (Exception e) {
    	    JOptionPane.showMessageDialog(null, "error creando producto"+ e);
            //System.out.println("Error: "+ e);
	}
    }
    
    public void Modificar(int idProducto, String Nombre, int Cantidad, String Descripcion, String FechaCompra, Double PrecioCompra,
                        Double PrecioVenta, Double PrecioPromo, int Categoria) {
	
	try { 
		
            String sentenciaSQL = new String();
            sentenciaSQL = "UPDATE Producto SET nombreProducto=?, cantidadProducto=?, descripcionProducto=?, fechaCompra=?, precioCompra=?, precioVenta=?, precioPromo=?, idCategoria=? WHERE idProducto = ?";
            PreparedStatement declaracion = conexion.prepareStatement(sentenciaSQL);
            
            declaracion.setInt(9, idProducto);
            declaracion.setString(1, Nombre);
            declaracion.setInt(2, Cantidad);
            declaracion.setString(3, Descripcion);
            declaracion.setString(4, FechaCompra );
            declaracion.setDouble(5,  PrecioCompra);
            declaracion.setDouble(6,PrecioVenta  );
            declaracion.setDouble(7, PrecioPromo );
            declaracion.setInt(8,Categoria  ); 
            
            int registro = declaracion.executeUpdate();
            if(registro > 0) {
                    JOptionPane.showMessageDialog(null, "Guardado");
            }
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error modificando producto"+ e);
	}
    }
    
    public int Eliminar(int idProducto) {
	 
        int re=0;
 
        try {
            Statement ejecutor = conexion.createStatement();


            ResultSet respuesta = ejecutor.executeQuery("Delete from Producto where idProducto ='" + idProducto +"'");

            if (respuesta.next()) {

                    re = 1;			
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al eliminar producto"+ e);
        }

        return re;
    }
    
}
