package Controlador;

import Conexion.Conexion;
import Modelo.Edificio;
import Modelo.Departamento;
import Modelo.Edificio;
import Modelo.ImagenAlmacen;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DepartamentoDAO extends Conexion {
    
    Edificio e=new Edificio();
    String mensaje="";

    public boolean AgregarDepartamento(Departamento usr) throws SQLException {
        Connection con = getConexion();
        CallableStatement cs = null;
        String sql = "call SP_AGREGAR_DEPA(?,?,?,?,?)";
        cs = con.prepareCall(sql);
        try {
            cs.setString(1, usr.getDepartamento());
            cs.setString(2, usr.getNumero());
            cs.setInt(3, usr.getValor());;
            cs.setInt(4, usr.getId_Estado());
            cs.setInt(5, usr.getId_edificio());
            cs.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean AgregarDepartamento2(Departamento usr, ImagenAlmacen mImagen) throws SQLException {
        Connection con = getConexion();
        CallableStatement cs = null;
        String sql = "call SP_GUARDAR_IMAGEN2(?,?,?,?,?,?,?)";
        cs = con.prepareCall(sql);
        try {
            cs.setString(1, usr.getDepartamento());
            cs.setString(2, usr.getNumero());
            cs.setInt(3, usr.getValor());;
            cs.setInt(4, usr.getId_edificio());
            cs.setInt(5, usr.getId_Estado());
            cs.setString(6, mImagen.getNombre());
            cs.setBytes(7, mImagen.getImagen());
            cs.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public  String buscarNro(String n_departamento) {
        String mensaje = "";
        try {
            Connection con = getConexion();
            String consulta= "SELECT n_departamento FROM departamentos WHERE n_departamento=? AND estado_id_estado!=4";
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement(consulta);
            ps.setString(1, n_departamento);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                mensaje = "Departamento encontrado";
            }else{
                mensaje = "Departamento no encontrado";
            }
            
            con.close();
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
        return mensaje;

    }
    
    public  String buscarNro2(String n_departamento) {
        String mensaje = "";
        try {
            Connection con = getConexion();
            String consulta= "SELECT n_departamento FROM departamentos WHERE n_departamento=?";
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement(consulta);
            ps.setString(1, n_departamento);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                mensaje = "Departamento encontrado";
            }else{
                mensaje = "Departamento no encontrado";
            }
            
            con.close();
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
        return mensaje;

    }
    
    
    public Departamento buscarDepartamento(String id_departamento) throws Exception {
Connection con = getConexion();
        Departamento dec = new Departamento();
        
        PreparedStatement ps = con.prepareStatement("SELECT id_departamento, departamento,n_departamento,valor,estado_id_estado,nombre FROM departamentos INNER JOIN edificio ON departamentos.edificio_id_edificio=edificio.id_edificio WHERE n_departamento= ?");
        ps.setString(1, id_departamento);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {

            dec.setId(rs.getInt(1));
            dec.setDepartamento(rs.getString(2));
            dec.setNumero(rs.getString(3));
            dec.setValor(rs.getInt(4));
            dec.setId_Estado(rs.getInt(5));
            dec.setNom_edificio(rs.getString(6));
        }

        return dec;

    }
    
    public void modificarDepartamento(Departamento dep){
        try {
            Connection con = getConexion();
            String consulta = "UPDATE departamentos SET departamento = ?, n_departamento = ?, valor = ?, edificio_id_edificio = ? WHERE n_departamento=?";
        
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement(consulta);
            ps.setString(1, dep.getDepartamento());
            ps.setString(2, dep.getNumero());
            ps.setInt(3, dep.getValor());
            ps.setInt(4, dep.getId_edificio());
            ps.setString(5, dep.getN_valido());
            
            int i = ps.executeUpdate();
            if (i > 0) {
                JOptionPane.showMessageDialog(null, "Datos modificados");
            }else{
                JOptionPane.showMessageDialog(null, "Error de solicitud");
            }
            
            con.close();
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
    
      public void modificarDisponibilidad(Departamento dep){
        try {
            Connection con = getConexion();
            String consulta = "UPDATE departamentos SET estado_id_estado = ? WHERE n_departamento=?";
        
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement(consulta);
            ps.setInt(1, dep.getId_Estado());
            ps.setString(2, dep.getN_valido());
            
            int i = ps.executeUpdate();
            if (i > 0) {
                JOptionPane.showMessageDialog(null, "Datos modificados");
            }else{
                JOptionPane.showMessageDialog(null, "Error de solicitud");
            }
            
            con.close();
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
      
       public void eliminarDisponibilidad(Departamento dep){
        try {
            Connection con = getConexion();
            String consulta = "UPDATE departamentos SET estado_id_estado = ? WHERE n_departamento=?";
        
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement(consulta);
            ps.setInt(1, dep.getId_Estado());
            ps.setString(2, dep.getN_valido());
            
            int i = ps.executeUpdate();
            if (i > 0) {
                JOptionPane.showMessageDialog(null, "Departamento eliminado");
            }else{
                JOptionPane.showMessageDialog(null, "Error de solicitud");
            }
            
            con.close();
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void eliminarDep(String numero) throws SQLException{
        Connection con=getConexion();
        String sql="DELETE FROM departamentos WHERE n_departamento=?";
        PreparedStatement ps;
        ResultSet rs;
        ps = con.prepareStatement(sql);
        ps.setString(1, numero);
        int resultado = ps.executeUpdate();
        if (resultado>0) {
            JOptionPane.showMessageDialog(null, "Departamento Eliminado");
        }else{
            JOptionPane.showMessageDialog(null, "Departamento no se puede eliminar");
        }
        con.close();
    }
    
        public void eliminarDep99(int numero) throws SQLException{
        Connection con=getConexion();
        String sql="DELETE FROM perfil WHERE id_perfil=?";
        PreparedStatement ps;
        ResultSet rs;
        ps = con.prepareStatement(sql);
        ps.setInt(1, numero);
        int resultado = ps.executeUpdate();
        if (resultado>0) {
            JOptionPane.showMessageDialog(null, "Departamento Eliminado");
        }else{
            JOptionPane.showMessageDialog(null, "Departamento no se puede eliminar");
        }
        con.close();
    }
    
    
     public void eliminarDep4(int numero) throws SQLException{
         try {
             Connection con=getConexion();
        String sql="DELETE FROM departamentos WHERE id_departamento=?";
        PreparedStatement ps;
        ResultSet rs;
        ps = con.prepareStatement(sql);
        ps.setInt(1, numero);
        int resultado = ps.executeUpdate();
        if (resultado>0) {
            JOptionPane.showMessageDialog(null, "Departamento Eliminado");
        }else{
            JOptionPane.showMessageDialog(null, "Departamento no se puede eliminar");
        }
        con.close();
         } catch (Exception e) {
         }
        
    }
    
     public String eliminarDepartamento(int id){
         Connection con=getConexion();
         PreparedStatement ps;
         String sql="DELETE FROM perfil WHERE id_perfil=?";
         
         try {
             ps = con.prepareStatement(sql);
             ps.setInt(1, id);
             mensaje = "Eliminado de una";
             ps.execute();
             ps.close();
         } catch (SQLException e) {
             mensaje="No se puede modificar: "+e.getMessage();
         }
         return mensaje;
     }
     
     public void eliminarDep1(String numero) throws SQLException{
        Connection con=getConexion();
        CallableStatement cs;
        String sql="call SP_ELIMINAR_TODO_DEPARTAMENTO(?)";
        cs = con.prepareCall(sql);
        cs.setString(1, numero);
        int resultado = cs.executeUpdate();
        if (resultado>0) {
            JOptionPane.showMessageDialog(null, "Departamento Eliminado");
        }else{
            JOptionPane.showMessageDialog(null, "Departamento no se puede eliminar");
        }
        con.close();
    }
     
     public boolean eliminar(int id){
         try {
             String sql="delete from departamentos where id_departamento=?";
             Connection connection = this.getConexion();
             PreparedStatement ps = connection.prepareStatement(sql);
             ps.setInt(1, id);
             ps.executeQuery();
             ps.close();
             return true;
             
         } catch (Exception e) {
             return false;
         }
     }
    
    public void buscarId(){

}}
