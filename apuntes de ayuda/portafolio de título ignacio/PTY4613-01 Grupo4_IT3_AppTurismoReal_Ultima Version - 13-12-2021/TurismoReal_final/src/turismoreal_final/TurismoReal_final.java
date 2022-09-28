
package turismoreal_final;

import Controlador.DepartamentoDAO;
import Modelo.Departamento;

public class TurismoReal_final {
    DepartamentoDAO dao=new DepartamentoDAO();
    Departamento dep=new Departamento();
    public String mensaje="";
    public void eliminar(){

         mensaje = dao.eliminarDepartamento(2);
         System.out.println(mensaje);
    }

    public static void main(String[] args) {
        TurismoReal_final t=new TurismoReal_final();
        t.eliminar();
    }
    
}
