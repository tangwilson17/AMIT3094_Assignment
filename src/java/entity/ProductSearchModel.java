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
public class ProductSearchModel {

    @PersistenceContext
    EntityManager mgr;
    @Resource
    Query query;

    public ProductSearchModel(EntityManager mgr) {
        this.mgr = mgr;
    }

    //For searchProduct Servlet
    public List<Product> searchProducts(String searchProd) {

        try {
            // Try parsing searchProd as an integer
            int searchProdID = Integer.parseInt(searchProd);
            query = mgr.createNamedQuery("Product.searchProductsID");
            query.setParameter("searchProdID", searchProdID);

        } catch (NumberFormatException e) {
            // searchProd cannot be parsed as an integer, search by name instead
            query = mgr.createNamedQuery("Product.searchProductsName");
            query.setParameter("searchProdName", "%" + searchProd + "%");
        }

        List<Product> prodList = query.getResultList();
        return prodList;
    }

    // For FilterOnSearch Servlet
    public List<Product> FilterOnSearch(String searchProd, int option) {
        switch (option) {
            case 1: {
                try {
                    int searchProdID = Integer.parseInt(searchProd);
                    query = mgr.createNamedQuery("Product.filterASCOnSearchID");
                    query.setParameter("searchProdID", searchProdID);

                } catch (NumberFormatException e) {
                    query = mgr.createNamedQuery("Product.filterASCOnSearchName");
                    query.setParameter("searchProdName", "%" + searchProd + "%");
                }
                break;
            }
            case 2: {
                try {
                    int searchProdID = Integer.parseInt(searchProd);
                    query = mgr.createNamedQuery("Product.filterDESCOnSearchID");
                    query.setParameter("searchProdID", searchProdID);

                } catch (NumberFormatException e) {
                    query = mgr.createNamedQuery("Product.filterDESCOnSearchName");
                    query.setParameter("searchProdName", "%" + searchProd + "%");

                }
                break;
            }
            case 3: {
                try {
                    int searchProdID = Integer.parseInt(searchProd);
                    query = mgr.createNamedQuery("Product.filterAZOnSearchID");
                    query.setParameter("searchProdID", searchProdID);

                } catch (NumberFormatException e) {
                    query = mgr.createNamedQuery("Product.filterAZOnSearchName");
                    query.setParameter("searchProdName", "%" + searchProd + "%");
                }
                break;
            }
            case 4: {
                try {
                    int searchProdID = Integer.parseInt(searchProd);
                    query = mgr.createNamedQuery("Product.filterZAOnSearchID");
                    query.setParameter("searchProdID", searchProdID);

                } catch (NumberFormatException e) {
                    query = mgr.createNamedQuery("Product.filterZAOnSearchName");
                    query.setParameter("searchProdName", "%" + searchProd + "%");
                }
                break;
            }
            default:
                break;
        }
        return query.getResultList();
    }

}
