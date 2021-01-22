package DAOS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class categoriaDAO {
    
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
    
    public void Crear(String Nombre, String Descripcion) {
	
	try {
            String sentenciaSQL = new String();
            sentenciaSQL = "INSERT INTO Categoria(nombreCategoria, descripcionCategoria) VALUES (?,?)";
            PreparedStatement declaracion = conexion.prepareStatement(sentenciaSQL);
            
            declaracion.setString(1, Nombre);
            declaracion.setString(2,  Descripcion); 
            
            int registro = declaracion.executeUpdate();
            if(registro > 0) {
        	JOptionPane.showMessageDialog(null, "Categoria Registrado");
            }
        
    } catch (Exception e) {
    	    JOptionPane.showMessageDialog(null, "error creando categoria"+ e);
            //System.out.println("Error: "+ e);
	}
    }
    
    public void Modificar(int idCategoria, String Nombre, String Descripcion) {
	
	try { 
            String sentenciaSQL = new String();
            sentenciaSQL = "UPDATE Categoria SET nombreCategoria=?, descripcionCategoria=? WHERE idCategoria = ?";
            PreparedStatement declaracion = conexion.prepareStatement(sentenciaSQL);
            
            declaracion.setInt(3, idCategoria);
            declaracion.setString(1, Nombre);
            declaracion.setString(2, Descripcion);
            
            int registro = declaracion.executeUpdate();
            if(registro > 0) {
                    JOptionPane.showMessageDialog(null, "Guardado");
            }
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error modificando categoria"+ e);
	}
    }
    
    public int Eliminar(int idCategoria) {
	 
        int re=0;
 
        try {
            Statement ejecutor = conexion.createStatement();


            ResultSet respuesta = ejecutor.executeQuery("Delete from Categoria where idCategoria ='" + idCategoria +"'");

            if (respuesta.next()) {

                    re = 1;			
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al eliminar categoria: "+ e);
        }

        return re;
    }
    
}
