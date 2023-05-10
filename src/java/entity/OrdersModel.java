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
 * @author Kyan
 */
public class OrdersModel {

    @PersistenceContext
    EntityManager mgr;
    @Resource
    Query query;

    public OrdersModel(EntityManager mgr) {
        this.mgr = mgr;
    }

    public List<Orders> findAll() {
        List orderList = mgr.createNamedQuery("Orders.findAll").getResultList();
        return orderList;
    }

    public Orders findOrderByID(int ID) {
        Orders order = mgr.find(Orders.class, ID);
        return order;
    }


    public List<Orders> getOrderByCustomerCode() {
        List orderList = mgr.createNamedQuery("Orders.findByCustomer").getResultList();
        return orderList;
    }
}
