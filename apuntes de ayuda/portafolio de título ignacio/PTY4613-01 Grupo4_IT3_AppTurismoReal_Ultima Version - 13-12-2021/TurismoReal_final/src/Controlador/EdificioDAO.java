package Controlador;

import Modelo.Ciudad;
import Conexion.Conexion;
import Modelo.Edificio;
import Modelo.Estado;
import Modelo.Usuarios;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EdificioDAO extends Conexion {

    public ArrayList<Edificio> getListaEdificios() {
        Connection con = getConexion();
        Statement stmt;
        ResultSet rs;
        ArrayList<Edificio> ListaEdificios = new ArrayList<>();
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from edificio inner join ciudad on ciudad.id_ciudad=edificio.ciudad_id_ciudad");
            while (rs.next()) {
                Edificio edificio = new Edificio();
                edificio.setId(rs.getInt("id_edificio"));
                edificio.setNombre(rs.getString("nombre"));
                edificio.setDireccion(rs.getString("direccion"));
                edificio.setId_ciudad(rs.getInt("ciudad_id_ciudad"));
                edificio.setCiudad(rs.getString("ciudad"));
                ListaEdificios.add(edificio);

            }
        } catch (Exception e) {
        }
        return ListaEdificios;

    }

    public ArrayList<Estado> getListaEstado() {
        Connection con = getConexion();
        Statement stmt;
        ResultSet rs;
        ArrayList<Estado> ListaEstado = new ArrayList<>();
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from estado");
            while (rs.next()) {
                Estado edificio = new Estado();
                edificio.setId_estado(rs.getInt("id_estado"));
                edificio.setEstado(rs.getString("estado"));
                ListaEstado.add(edificio);

            }
        } catch (Exception e) {
        }
        return ListaEstado;

    }

    public ArrayList<Edificio> getListaEdificios1() {
        Connection con = getConexion();
        Statement stmt;
        ResultSet rs;
        ArrayList<Edificio> ListaEdificios = new ArrayList<>();
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from edificio");
            while (rs.next()) {
                Edificio edificio = new Edificio();
                edificio.setId(rs.getInt("id_edificio"));
                edificio.setNombre(rs.getString("nombre"));
                edificio.setDireccion(rs.getString("direccion"));
                edificio.setId_ciudad(rs.getInt("ciudad_id_ciudad"));
                ListaEdificios.add(edificio);

            }
        } catch (Exception e) {
        }
        return ListaEdificios;

    }

    public ArrayList<Ciudad> getListaCiudad() {
        Connection con = getConexion();
        Statement stmt;
        ResultSet rs;
        ArrayList<Ciudad> ListaCiudad = new ArrayList<>();
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from ciudad");
            while (rs.next()) {
                Ciudad edificio = new Ciudad();
                edificio.setId(rs.getInt("id_ciudad"));
                edificio.setCiudad(rs.getString("ciudad"));
                edificio.setId_region(rs.getInt("region_id_region"));
                ListaCiudad.add(edificio);

            }
        } catch (Exception e) {
        }
        return ListaCiudad;

    }

    public boolean AgregarEdificio(Edificio usr) throws SQLException {
        Connection con = getConexion();
        CallableStatement cs = null;
        String sql = "call SP_AGREGAR_EDIFICIO(?,?,?)";
        cs = con.prepareCall(sql);
        try {
            cs.setString(1, usr.getNombre());
            cs.setString(2, usr.getDireccion());
            cs.setInt(3, usr.getId_ciudad());;
            cs.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
