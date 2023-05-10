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
public class BrowseCategoryModel {

    @PersistenceContext
    EntityManager mgr;
    @Resource
    Query query;

    public BrowseCategoryModel(EntityManager mgr) {
        this.mgr = mgr;
    }

    //For BrowseCategory Servlet, PriceRangeOnCategory
    public List<Product> BrowseCategory(int categoryID) {
        query = mgr.createNamedQuery("Product.BrowseCategory");
        query.setParameter("categoryID", categoryID);
        // Execute the query and get the list of products
        List<Product> prodList = query.getResultList();

        return prodList;
    }

    // For FilterBasedOnCategory Servlet
    public List<Product> FilterBasedOnCategory(int categoryID, int option) {
        switch (option) {
            case 1: {
                query = mgr.createNamedQuery("Product.filterASCOnCategory");
                query.setParameter("categoryID", categoryID);
                break;
            }
            case 2: {
                query = mgr.createNamedQuery("Product.filterDESCOnCategory");
                query.setParameter("categoryID", categoryID);
                break;
            }
            case 3: {
                query = mgr.createNamedQuery("Product.filterAZOnCategory");
                query.setParameter("categoryID", categoryID);
                break;
            }
            case 4: {
                query = mgr.createNamedQuery("Product.filterZAOnCategory");
                query.setParameter("categoryID", categoryID);
                break;
            }
            default:
                break;
        }
        List<Product> prodList = query.getResultList();
        return prodList;
    }

}
