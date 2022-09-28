
package Modelo;

public class Inventario {
    private int id_inventario;
    private String nombre;
    private int cantidad;
    private int valor;
    private int id_departamento;

    public Inventario() {
    }

    public Inventario(int id_inventario, String nombre, int cantidad, int valor, int id_departamento) {
        this.id_inventario = id_inventario;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.valor = valor;
        this.id_departamento = id_departamento;
    }

    public Inventario(String nombre, int cantidad, int valor) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.valor = valor;
    }
    
    

    public int getId_inventario() {
        return id_inventario;
    }

    public void setId_inventario(int id_inventario) {
        this.id_inventario = id_inventario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }
    
    
}
