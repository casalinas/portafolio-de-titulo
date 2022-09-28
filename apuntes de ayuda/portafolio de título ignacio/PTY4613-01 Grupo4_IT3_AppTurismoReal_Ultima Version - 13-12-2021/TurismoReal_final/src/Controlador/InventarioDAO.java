/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexion.Conexion;
import Modelo.Inventario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nacho
 */
public class InventarioDAO extends Conexion {
    
    
     public boolean AgregarInventario(Inventario usr) throws SQLException
    {
        Connection con= getConexion();
        CallableStatement cs=null;
        String sql="call SP_AGREGAR_INVENTARIO(?,?,?)";
        cs=con.prepareCall(sql);
        try {
            cs.setString(1, usr.getNombre());
            cs.setInt(2, usr.getCantidad());
            cs.setInt(3, usr.getValor());;
            cs.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }   
     
    public boolean AgregarInventario2(Inventario usr) throws SQLException
    {
        Connection con= getConexion();
        CallableStatement cs=null;
        String sql="call SP_AGREGAR_INVENTARIO(?,?,?)";
        cs=con.prepareCall(sql);
        try {
            cs.setString(1, usr.getNombre());
            cs.setInt(2, usr.getCantidad());
            cs.setInt(3, usr.getValor());
            cs.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }   
}
