/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author nacho
 */
public class Departamento {
    private int id;
    private String departamento;
    private String numero;
    private int valor;
    private int id_estado;
    private int id_edificio;
    private String n_valido;
    private String nom_edificio;
    

    public Departamento() {
    }

    public Departamento(int id, String departamento, String numero, int valor, int id_estado, int id_edificio) {
        this.id = id;
        this.departamento = departamento;
        this.numero = numero;
        this.valor = valor;
        this.id_estado = id_estado;
        this.id_edificio = id_edificio;
    }

    public Departamento(String departamento, String numero, int valor, int id_estado, int id_edificio) {
        this.departamento = departamento;
        this.numero = numero;
        this.valor = valor;
        this.id_estado = id_estado;
        this.id_edificio = id_edificio;
    }

    public Departamento(int id, String departamento, String numero) {
        this.id = id;
        this.departamento = departamento;
        this.numero = numero;
    }

    public Departamento(int id, String departamento, String numero, int valor, int id_estado, int id_edificio, String n_valido) {
        this.id = id;
        this.departamento = departamento;
        this.numero = numero;
        this.valor = valor;
        this.id_estado = id_estado;
        this.id_edificio = id_edificio;
        this.n_valido = n_valido;
    }

    public Departamento(int id, String departamento, String numero, int valor, int id_estado, int id_edificio, String n_valido, String nom_edificio) {
        this.id = id;
        this.departamento = departamento;
        this.numero = numero;
        this.valor = valor;
        this.id_estado = id_estado;
        this.id_edificio = id_edificio;
        this.n_valido = n_valido;
        this.nom_edificio = nom_edificio;
    }

    public String getNom_edificio() {
        return nom_edificio;
    }

    public void setNom_edificio(String nom_edificio) {
        this.nom_edificio = nom_edificio;
    }
    
    

    public String getN_valido() {
        return n_valido;
    }

    public void setN_valido(String n_valido) {
        this.n_valido = n_valido;
    }
    
    
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getId_Estado() {
        return id_estado;
    }

    public void setId_Estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public int getId_edificio() {
        return id_edificio;
    }

    public void setId_edificio(int id_edificio) {
        this.id_edificio = id_edificio;
    }

    @Override
    public String toString() {
        return departamento;
    }
    
    
}
