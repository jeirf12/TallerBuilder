/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.domain;

/**
 *
 * @author fallen
 */
public class Dish {
    protected String nombre;
    protected double price;
    protected String imagen;

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String Imagen) {
        this.imagen = Imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
