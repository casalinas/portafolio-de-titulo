package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {

   private final String base = "turismoreal";
   private final String user = "TurismoReal";
   private final String password = "TurismoReal";
   private final String url = "jdbc:oracle:thin:@localhost:1521:xe";
   private Connection con=null;
   
   public Connection getConexion(){
       try {
           Class.forName("oracle.jdbc.OracleDriver");
           con = DriverManager.getConnection(url, user, password);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
       }
       return con;
   }
   
   public void desconectar(){
       try {
           this.con.close();
       } catch (Exception e) {
       }
   }
}
