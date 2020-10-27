/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.orientalApp;

import co.unicauca.restaurant.access.OrientalRepositoryImplArrays;
import co.unicauca.restaurant.domain.Product;
import co.unicauca.restaurant.domain.Size;
import co.unicauca.restaurant.services.DishBuilder;
import co.unicauca.restaurant.utilities.Consola;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fallen
 */
public class OrientalDishBuilder extends DishBuilder{
    private OrientalDish myOrientalDish;
    /**
     * Lee de forma dinamica los productos a partir de una lista
     * 
     * @param myProducts
     * @param foodPart
     * @return 
     */
    private Product read(List<Product> myProducts, String foodPart) {
        int input=0;
        while (input<1 || input>myProducts.size()){
            int i = 1;
            Consola.escribirSaltarLinea("Seleccione una " + foodPart, false);
            for (Product each : myProducts) {
                Consola.escribirSaltarLinea("" + i + ". " + each.getName() + ":" + each.getPrice(), false);
                i++;
            }
            input=Consola.leer("Ingrese el código de la "+foodPart +":",input, false);
        }
        return myProducts.get(input - 1);
    }
    /**
     * Inicia la creacion del plato
     * 
     * @param nombre
     * @param imagen
     * @return 
     */
    @Override
    public DishBuilder init(String nombre,String imagen) {
        myRepository = new OrientalRepositoryImplArrays();
        myDish = new OrientalDish(nombre,imagen,0.0);
        myOrientalDish = (OrientalDish) myDish;
        //Obtenemos todos los productos
        allProducts = myRepository.findAll();
        // Obtenemos las bases y las opciones
        bases = new ArrayList<>();
        options = new ArrayList<>();
        for (Product each : allProducts) {
            if (each.getId() < 4) {
                bases.add(each);
            } else if(each.getId()>3 && each.getId()<7){
                options.add(each);
            }
        }
        return this;
    }
    /**
     * Añade la base del plato
     * 
     * @return 
     */
    @Override
    public DishBuilder setCore() {
        myOrientalDish.setBase(read(bases, "Base"));
        return this;
    }
    
    /**
     * Añade los acompañantes del plato
     * 
     * @return 
     */
    @Override
    public boolean addPart() {
        String opcion=" ";
        myOrientalDish.addOption(read(options, "Opcion"));
        opcion=Consola.leer("Presione S para más opciones sino cualquier "
                + "tecla para decir que no",opcion,false);
        return opcion.matches("[Ss]");
    }
    
    /**
     * elige el tamaño del plato
     * 
     * @return 
     */
    @Override
    public DishBuilder setSize() {
        String tamano = " ";
        do {
            tamano = Consola.leer("Presione la letra correspondiente para el tamaño "
                    + "Personal(P), Doble (D), Familiar (F)", tamano, false);
        } while (!Consola.es_P_D_F(tamano));
        if (tamano.equals("F")) {
            myOrientalDish.setSize(Size.FAMILY);
        }
        if (tamano.equals("D")) {
            myOrientalDish.setSize(Size.DOUBLE);
        }
        if (tamano.equals("P")) {
            myOrientalDish.setSize(Size.PERSONAL);
        }
        return this;
    }
}
