/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.access;

import co.unicauca.restaurant.domain.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fallen
 */
public class ItalianRepositoriImplArrays implements IProductRepository{
    public static List<Product> products;
    
    public ItalianRepositoriImplArrays(){
        products = new ArrayList<>();
        initialize();
    }
    
    private void initialize() {
        products.add(new Product(1, "Rissoto", 5200d));
        products.add(new Product(2, "Lasaña de carne", 7300d));
        products.add(new Product(3, "Espaguetis a la boloñesa", 9000d));
        products.add(new Product(4, "Virutas de queso", 5700d));
        products.add(new Product(5, "Ensalada capresse", 4200d));
        products.add(new Product(6, "Pulpo en purgatorio", 6200d));
    }
    
    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(Integer id) {
        for(Product prod:products){
            if (prod.getId() == id) {
                return prod;
            }
        }
        return null;
    }

    @Override
    public boolean create(Product newProduct) {
        Product prod = this.findById(newProduct.getId());
        if (prod != null) {
                //Ya existe
                return false;
        }
        products.add(newProduct);
        return true;
    }

    @Override
    public boolean update(Product newProduct) {
        Product prod = this.findById(newProduct.getId());
        if (prod != null) {
            prod.setName(newProduct.getName());
            prod.setPrice(newProduct.getPrice());
        return true;
        }
    return false;
    }

    @Override
    public boolean delete(Integer id) {
        for (Product prod : products) {
                if (prod.getId() == id) {
                    products.remove(prod);
                    return true;
                }
        }
        return false;
    }
}
