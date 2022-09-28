
package Modelo;

public class Edificio {
    private int id;
    private String nombre;
    private String direccion;
    private int id_ciudad;
    private String ciudad;

    public Edificio() {
    }

    public Edificio(int id, String nombre, String direccion, int id_ciudad, String ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.id_ciudad = id_ciudad;
        this.ciudad = ciudad;
    }

    public Edificio(int id, String ciudad,int id_ciudad) {
        this.id = id;
        this.ciudad = ciudad;
        this.id_ciudad= id_ciudad;
        
    }

    public Edificio(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    

    public int getId() {
        return id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(int id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    
    public String toString(){
     return nombre;
    }
    
    
    
}
