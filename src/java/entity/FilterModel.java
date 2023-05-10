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
public class FilterModel {

    @PersistenceContext
    EntityManager mgr;
    @Resource
    Query query;

    public FilterModel(EntityManager mgr) {
        this.mgr = mgr;
    }

    //For FilterOption Servlet
    public List<Product> FilterOption(int option) {

        switch (option) {
            case 1: {
                query = mgr.createNamedQuery("Product.filterASC");
                break;
            }
            case 2: {
                query = mgr.createNamedQuery("Product.filterDESC");
                break;
            }
            case 3: {
                query = mgr.createNamedQuery("Product.filterAZ");
                break;
            }
            case 4: {
                query = mgr.createNamedQuery("Product.filterZA");
                break;
            }
            default:
                break;
        }
        List<Product> prodList = query.getResultList();
        return prodList;
    }
}
