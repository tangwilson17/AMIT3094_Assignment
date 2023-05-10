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
public class OrderListModel {

    @PersistenceContext
    EntityManager mgr;
    @Resource
    Query query;

    public OrderListModel(EntityManager mgr) {
        this.mgr = mgr;
    }

    public List<OrderList> findAll() {
        List orderL = mgr.createNamedQuery("OrderList.findAll").getResultList();
        return orderL;
    }

    public OrderList findOrderLByID(int ID) {
        OrderList orderL = mgr.find(OrderList.class, ID);
        return orderL;
    }

}
