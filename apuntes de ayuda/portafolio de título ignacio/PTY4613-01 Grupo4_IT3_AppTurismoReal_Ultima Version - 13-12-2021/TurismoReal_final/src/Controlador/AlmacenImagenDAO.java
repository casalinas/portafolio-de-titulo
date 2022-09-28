
package Controlador;

import Conexion.Conexion;
import Modelo.ImagenAlmacen;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class AlmacenImagenDAO extends Conexion{
    Connection con= getConexion();

    
     
   
    public boolean AgregarImagen1(ImagenAlmacen mImagen) throws SQLException{
        CallableStatement cs=null;
       // Statement Consulta;
        //ResultSet Resultado;
        String SQL_AGREGAR = "call  SP_GUARDAR_IMAGEN(?,?,?)";
        cs=con.prepareCall(SQL_AGREGAR);
        try{
            cs.setString(1, mImagen.getNombre());
            cs.setBytes(2, mImagen.getImagen());
            cs.setInt(3, mImagen.getId_departamento());
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
   
    public void AgregarImagen(ImagenAlmacen mImagen){
    
        Statement Consulta;
        ResultSet Resultado;
        String SQL_AGREGAR = "insert into imagenes values(?,?,?,?)";
        PreparedStatement ps=null;
        try {
            ps=con.prepareStatement(SQL_AGREGAR);
            ps.setInt(1, mImagen.getId());
            ps.setString(2, mImagen.getNombre());
            ps.setBytes(3, mImagen.getImagen());
            ps.setInt(4, mImagen.getId_departamento());
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
    }
    
    
    public ArrayList CargarImagen(){
        Statement Consulta;
        ResultSet Resultado;
        String SQL_CONSULTA = "SELECT * FROM imagenes";
        ArrayList imagenes = new ArrayList();
        try {
            Consulta = con.createStatement();
            Resultado = Consulta.executeQuery(SQL_CONSULTA);
            while(Resultado.next()){
                ImagenAlmacen mImagen=new ImagenAlmacen();
                mImagen.setId(Resultado.getInt("id_imagen"));
                mImagen.setNombre(Resultado.getString("nombre"));
                mImagen.setImagen(Resultado.getBytes("imagen"));
                mImagen.setId_departamento(Resultado.getInt("departamentos_id_departamento"));
                imagenes.add(mImagen);
            }
        } catch (Exception e) {
            return null;
        }
        return imagenes;
    }
    
    
    
}
