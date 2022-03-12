/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8p2_juanmolina_11621058;

import java.awt.Color;
import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author Hwan
 */
public class carro implements Serializable{
    private int id,distancia;
    private String nombre, tipo;
    private Color color;

    public carro() {
    }

    public carro(int id, String nombre, String tipo, Color color) {
        this.id = id;
        this.nombre = nombre;
        this.color = color;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia += distancia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    

    @Override
    public String toString() {
        return "carro{" + "id=" + id + ", distancia=" + distancia + ", nombre=" + nombre + ", tipo=" + tipo + ", color=" + color + '}';
    }
    
    
    
}
