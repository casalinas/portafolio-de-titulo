
package Modelo;


public class Ciudad {
    public int id;
    public String ciudad;
    private int id_region;

    public Ciudad() {
    }

    public Ciudad(int id, String ciudad) {
        this.id = id;
        this.ciudad = ciudad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getId_region() {
        return id_region;
    }

    public void setId_region(int id_region) {
        this.id_region = id_region;
    }


    public String toString() {
        return ciudad;
    }

    
}