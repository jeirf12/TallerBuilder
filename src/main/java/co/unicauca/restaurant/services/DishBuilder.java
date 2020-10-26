/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.services;

import co.unicauca.restaurant.domain.Dish;

/**
 *
 * @author fallen
 */
public abstract class DishBuilder {
    protected Dish myDish;
    
    Dish getDish() {
        return myDish;
    }

    public abstract DishBuilder init(String nombre,String imagen);

    public abstract DishBuilder setCore();

    public abstract boolean addPart();

    public abstract DishBuilder setSize();
}
