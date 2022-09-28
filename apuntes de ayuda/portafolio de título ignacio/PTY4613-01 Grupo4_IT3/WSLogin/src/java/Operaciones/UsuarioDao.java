/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import Conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author el7se
 */
public class UsuarioDao {
    private Connection conexion; 
    
   public UsuarioDao() {
   
   }  
   
   public int Login(String user,String pass) throws SQLException{
       int tipo =0;
       try {
           this.conexion = new Conexion().getConexion();
           String script = "SELECT u.PERFIL_ID_PERFIL FROM USUARIOS u INNER JOIN USUARIOS_CONTRASENAS uc ON u.ID_USUARIO = uc.USUARIOS_ID_USUARIO WHERE u.RUT = '"+user+"' AND uc.CONTRASENA = '"+pass+"' ";
            CallableStatement cstmt = this.conexion.prepareCall(script);
            
            ResultSet rs = cstmt.executeQuery();
            
            while(rs.next()){
                tipo = rs.getInt("PERFIL_ID_PERFIL");
            }
           
       } catch (Exception e) {
           System.out.println("Error al Ingresar"+e.getMessage());
       }finally {
           this.conexion.close();
       }
       return tipo;
   }
}
