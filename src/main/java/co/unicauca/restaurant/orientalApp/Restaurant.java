/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.orientalApp;

import co.unicauca.restaurant.domain.Dish;
import co.unicauca.restaurant.domain.Menu;
import co.unicauca.restaurant.services.DishDirector;
import co.unicauca.restaurant.utilities.Consola;

/**
 *
 * @author fallen
 */
public class Restaurant {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String ruta="";
        DishDirector directorOriental = new DishDirector(new OrientalDishBuilder());
        DishDirector directorItalian =new DishDirector(new ItalianDishBuilder());
        
        directorOriental.create("sopaArroz",ruta);
        Dish myDish = directorOriental.getDish();
        
        Menu menOriental=new Menu("Oriental");
        menOriental.setPlatos(myDish);
        Consola.escribirSaltarLinea("Menu "+menOriental.getNombre(), false);
        for (Dish plato : menOriental.getPlatos()) {
            Consola.escribirSaltarLinea("plato: "+plato.getNombre(), false);
            Consola.escribirSaltarLinea("Precio: "+plato.getPrice(), false);
        }
        //Consola.escribirSaltarLinea("El plato Oriental"+myDish.getNombre()+"le cuesta: "+ myDish.getPrice(), false);
        directorItalian.create("Spaguetti",ruta);
        Dish myDishIta=directorItalian.getDish();

        Menu menItaliano=new Menu("Italiano");
        menItaliano.setPlatos(myDishIta);
        Consola.escribirSaltarLinea("Menu "+menItaliano.getNombre(), false);
        for (Dish plato : menItaliano.getPlatos()) {
            Consola.escribirSaltarLinea("plato: "+plato.getNombre(), false);
            Consola.escribirSaltarLinea("Precio: "+plato.getPrice(), false);
        }
        //Consola.escribirSaltarLinea("El plato Italiano"+myDishIta.getNombre()+"le cuesta: "+myDishIta.getPrice(), false);
        
    }
    
}
