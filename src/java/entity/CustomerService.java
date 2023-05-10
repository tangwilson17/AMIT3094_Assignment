/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.List;
import javax.annotation.Resource;
import javax.persistence.*;

/**
 *
 * @author User
 */
public class CustomerService {
    @PersistenceContext
    EntityManager mgr;
    @Resource
    Query query;

    public CustomerService(EntityManager mgr) {
        this.mgr = mgr;
    }

    public boolean addCustomer(Customer customer) {
        mgr.persist(customer);
        return true;
    }

    public Customer findCustomerByEmail(String email) {
        Query query = mgr.createNamedQuery("Customer.findByEmail");
        query.setParameter("email", email);
        Customer customer =  (Customer) query.getSingleResult();
        return customer;
    }

    public boolean updateCustomer(Customer customer) {
        Customer tempCust = findCustomerByEmail(customer.getEmail());
        if (tempCust != null) {
            tempCust.setPassword(customer.getPassword());
            
            return true;
        }
        return false;
   }
    
    public boolean checkIfEmailExists(String email) {
        try{
            Query query = mgr.createNamedQuery("Customer.findByEmail");
            query.setParameter("email", email);
            query.getSingleResult();
            return true;
        }catch(NoResultException ex){
            return false;
        }catch(Exception e){
            return false;
        }
    }
}
