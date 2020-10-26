/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.access;

import co.unicauca.restaurant.domain.Product;
import java.util.List;

/**
 *  Interface de los servicios del repositorio
 * @author jhonfer Ruiz
 */
public interface IProductRepository {
    List<Product> findAll();
    Product findById(Integer id);
    boolean create(Product newProduct);
    boolean update(Product newProduct);
    boolean delete(Integer id);
}
