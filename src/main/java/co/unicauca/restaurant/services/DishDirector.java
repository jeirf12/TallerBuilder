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
public class DishDirector {

    private DishBuilder builder;

    public DishDirector(DishBuilder builder) {
        this.builder = builder;
    }

    public Dish getDish() {
        return builder.getDish();
    }

    public void create(String nombre,String imagen) {
        boolean masPartes = true;
        builder.init(nombre,imagen);
        builder.setCore();
        while (masPartes) {
            masPartes = builder.addPart();
        }
        builder.setSize();
    }
}
