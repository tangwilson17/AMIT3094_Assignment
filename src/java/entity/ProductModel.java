/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author mayte
 */
public class ProductModel {

    @PersistenceContext
    EntityManager mgr;

    public ProductModel(EntityManager mgr) {
        this.mgr = mgr;
    }

    // For DisplayProduct Servlet
    public List<Product> findAll() {
        List prodList = mgr.createNamedQuery("Product.findAll").getResultList();
        return prodList;
    }

    public Product findItemByID(int ID) {
        Product prod = mgr.find(Product.class, ID);
        return prod;
    }
}
