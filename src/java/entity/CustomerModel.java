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
public class CustomerModel {
    
    @PersistenceContext
    EntityManager mgr;
    @Resource
    Query query;

    public CustomerModel(EntityManager mgr) {
        this.mgr = mgr;
    }

       public List<Customer> findAll() {
        List catList = mgr.createNamedQuery("Customer.findAll").getResultList();
        return catList;
    }
       
        public Customer findCustByName(String Name) {
        Customer cust = mgr.find(Customer.class, Name);
        return cust;
    }
}
