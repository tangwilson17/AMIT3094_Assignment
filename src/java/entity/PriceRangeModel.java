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
public class PriceRangeModel {

    @PersistenceContext
    EntityManager mgr;
    @Resource
    Query query;
    String queryString;

    public PriceRangeModel(EntityManager mgr) {
        this.mgr = mgr;
    }

    // For PriceRange Servlet
    public List<Product> PriceRange(double minNum, double maxNum) {
        query = mgr.createNamedQuery("Product.priceRange");
        query.setParameter("minNum", minNum);
        query.setParameter("maxNum", maxNum);

        List<Product> prodList = query.getResultList();
        return prodList;
    }
}
