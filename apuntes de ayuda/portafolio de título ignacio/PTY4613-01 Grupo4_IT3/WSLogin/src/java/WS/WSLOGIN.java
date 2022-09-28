/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import Operaciones.UsuarioDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author el7se
 */
@WebService(serviceName = "WSLOGIN")
public class WSLOGIN {
    UsuarioDao dao = new UsuarioDao();
    /**
     * Web service operation
     */
    @WebMethod(operationName = "Login")
    public int Login(@WebParam(name = "user") String user, @WebParam(name = "pass") String pass) {
        int tipo = 0;
        
        try {
            tipo=dao.Login(user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(WSLOGIN.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tipo;
    }}
    /**
     * This is a sample web service operation
     */
  

