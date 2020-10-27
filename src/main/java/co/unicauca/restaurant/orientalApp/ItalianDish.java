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

/**
 *  Especializacion a un plato italiano
 * @author fallen
 */
public class ItalianDish extends Dish{

    public ItalianDish(String nombre,String imagen,double p) {
        this.nombre=nombre;
        this.imagen=imagen;
        this.price = p;
        this.myOptions = new ArrayList<>();
    }

    /**
     * Añade opciones al plato italiano
     * 
     * @param option 
     */
    public void addOption(Product option) {
        this.getMyOptions().add(option);
    }
    /**
     * Calcula el precio del plato italiano
     * @return 
     */
    @Override
    public double getPrice(){
        this.price = this.base.getPrice();
        for(Product each: myOptions){
            price = price + each.getPrice();
        }
        if(size==Size.DOUBLE) price = 2*price;
        if(size==Size.FAMILY) price = 3.3*price;
        return price;
    }
}
