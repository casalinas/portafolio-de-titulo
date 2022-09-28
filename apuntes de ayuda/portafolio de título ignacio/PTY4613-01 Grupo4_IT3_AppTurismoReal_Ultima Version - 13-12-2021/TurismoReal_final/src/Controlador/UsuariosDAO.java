package Controlador;

import Conexion.Conexion;
import Modelo.Usuarios;
import Modelo.Usuarios_pass;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UsuariosDAO extends Conexion {

    public boolean newinsertar(Usuarios usr) throws SQLException {
        Connection con = getConexion();
        CallableStatement cs = null;
        String sql = "call SP_CREAR_USUARIO_ADMIN(?,?,?,?,?,?,?,?)";
        cs = con.prepareCall(sql);
        try {
            cs.setString(1, usr.getNombre());
            cs.setString(2, usr.getRut());
            cs.setString(3, usr.getAppat());
            cs.setString(4, usr.getApmat());
            cs.setString(5, usr.getTelefono());
            cs.setString(6, usr.getEmail());
            cs.setString(7, usr.getPassword());
            cs.setInt(8, usr.getR());
            cs.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean Login1(Usuarios usr) {
        CallableStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "call SP_VALIDAR_USUARIO(?,?,?)";
        try {
            ps = con.prepareCall(sql);
            ps.setString(1, usr.getRut());
            ps.setString(2, usr.getPassword());
            ps.setInt(3, usr.getR());
            rs = ps.executeQuery();

            if (rs.next()) {
                if (usr.getPassword().equals(rs.getString(2))) {
                    return true;
                } else {
                    return false;
                }

            }
        } catch (Exception e) {

        }
        return false;
    }

    public boolean Login(Usuarios_pass usr) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT usuario, contraseña from usuarios_contraseñas WHERE usuario=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            rs = ps.executeQuery();

            if (rs.next()) {
                if (usr.getContraseña().equals(rs.getString(2))) {
                    return true;
                } else {
                    return false;
                }

            }
        } catch (Exception e) {

        }
        return false;
    }

    public boolean buscarId(Usuarios_pass usr) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT id from usuarios_contraseñas WHERE usuario=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            rs = ps.executeQuery();

            if (rs.next()) {
                if (usr.getContraseña().equals(rs.getString(2))) {
                    return true;
                } else {
                    return false;
                }

            }
        } catch (Exception e) {

        }
        return false;
    }

    public String loginusuario(String rut, String contraseña) {
        String mensaje = "";

        try {
            Connection con = getConexion();
            PreparedStatement ps;
            ResultSet rs;
            String sql = "SELECT rut, contrasena FROM usuarios INNER JOIN usuarios_contrasenas ON usuarios.id_usuario=usuarios_contrasenas.usuarios_id_usuario WHERE perfil_id_perfil=2 AND rut=? AND contrasena=? ";
            ps = con.prepareStatement(sql);
            ps.setString(1, rut);
            ps.setString(2, contraseña);
            rs = ps.executeQuery();
            if (rs.next()) {
                mensaje = "Correcto";
            }else{
                mensaje="Incorrecto";
            }
            
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
        return mensaje;
    }
    
    public  String buscarRut(String rut) {
        String mensaje = "";
        try {
            Connection con = getConexion();
            String consulta= "SELECT rut FROM usuarios WHERE rut=?";
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement(consulta);
            ps.setString(1, rut);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                mensaje = "Cliente encontrado";
            }else{
                mensaje = "Cliente no encontrado";
            }
            
            con.close();
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
        return mensaje;

    }
    
     public void modificarCliente(Usuarios dep){
        try {
            Connection con = getConexion();
            String consulta = "UPDATE usuarios SET nombre = ?, rut = ?, appat = ?, apmat = ?, telefono=?, email=? WHERE rut=?";
        
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement(consulta);
            ps.setString(1, dep.getNombre());
            ps.setString(2, dep.getRut());
            ps.setString(3, dep.getAppat());
            ps.setString(4, dep.getApmat());
            ps.setString(5, dep.getTelefono());
            ps.setString(6, dep.getEmail());
            ps.setString(7, dep.getFalse_rut());
            
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

}
