/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.orientalApp;

import co.unicauca.restaurant.domain.Dish;
import co.unicauca.restaurant.domain.Product;
import co.unicauca.restaurant.domain.Size;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fallen
 */
public class ItalianDish extends Dish{
    private Product base;
    private final List<Product> myOptions;
    private Size size;

    public ItalianDish(String nombre,String imagen,double p) {
        this.nombre=nombre;
        this.imagen=imagen;
        this.price = p;
        myOptions = new ArrayList<>();
    }

    public void setBase(Product base) {
        this.base = base; 
    }

    public void addOption(Product option) {
        getMyOptions().add(option);
    }

    /**
     * @return the base
     */
    public Product getBase() {
        return base;
    }

    /**
     * @return the myOptions
     */
    public List<Product> getMyOptions() {
        return myOptions;
    }

    /**
     * @return the size
     */
    public Size getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public double getPrice(){
        price = base.getPrice();
        for(Product each: myOptions){
            price = price + each.getPrice();
        }
        if(size==Size.DOUBLE) price = 2*price;
        if(size==Size.FAMILY) price = 3.3*price;
        return price;
    }
}
