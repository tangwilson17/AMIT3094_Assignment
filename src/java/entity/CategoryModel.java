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
public class CategoryModel {
    
    @PersistenceContext
    EntityManager mgr;
    @Resource
    Query query;

    public CategoryModel(EntityManager mgr) {
        this.mgr = mgr;
    }

       public List<Category> findAll() {
        List catList = mgr.createNamedQuery("Category.findAll").getResultList();
        return catList;
    }
       
     //For ProductDetails Servlet
     public Category getCategoryByID(int categoryID){
         query = mgr.createNamedQuery("Category.findByCategoryid");
         query.setParameter("categoryid", categoryID);
         return (Category) query.getSingleResult();
     }
}
