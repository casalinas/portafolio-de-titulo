
package Modelo;


public class Usuarios {
    private int id_usuario;
    private String nombre;
    private String appat;
    private String apmat;
    private String rut;
    private String telefono;
    private String email;
    private String fecha_ingreso;
    private String password;
    private int r;
    private String false_rut;

    public int getR() {
        return r;
    }

    public Usuarios(int id_usuario, String nombre, String appat, String apmat, String rut, String telefono, String email, String fecha_ingreso, String password, int r, String false_rut, int id_perfil) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.appat = appat;
        this.apmat = apmat;
        this.rut = rut;
        this.telefono = telefono;
        this.email = email;
        this.fecha_ingreso = fecha_ingreso;
        this.password = password;
        this.r = r;
        this.false_rut = false_rut;
        this.id_perfil = id_perfil;
    }

    public Usuarios(String nombre, String appat, String apmat, String rut, String telefono, String email, String false_rut) {
        this.nombre = nombre;
        this.appat = appat;
        this.apmat = apmat;
        this.rut = rut;
        this.telefono = telefono;
        this.email = email;
        this.false_rut = false_rut;
    }

    public String getFalse_rut() {
        return false_rut;
    }

    public Usuarios() {
    }

    public void setFalse_rut(String false_rut) {
        this.false_rut = false_rut;
    }

    public void setR(int r) {
        this.r = r;
    }
    private int id_perfil;

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAppat() {
        return appat;
    }

    public void setAppat(String appat) {
        this.appat = appat;
    }

    public String getApmat() {
        return apmat;
    }

    public void setApmat(String apmat) {
        this.apmat = apmat;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }
    
    
    
}
