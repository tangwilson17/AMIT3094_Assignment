/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kyan
 */
@Entity
@Table(name = "ORDER_LIST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderList.findAll", query = "SELECT o FROM OrderList o"),
    @NamedQuery(name = "OrderList.findByOrderListId", query = "SELECT o FROM OrderList o WHERE o.orderListId = :orderListId"),
    @NamedQuery(name = "OrderList.findByOrderID", query = "SELECT o FROM OrderList o WHERE o.orderId = :orderId"),
    @NamedQuery(name = "OrderList.findByQty", query = "SELECT o FROM OrderList o WHERE o.qty = :qty"),
    @NamedQuery(name = "OrderList.findByOrderId", query = "SELECT o FROM OrderList o WHERE o.orderId = :orderId")
})
public class OrderList implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ORDER_LIST_ID")
    private Integer orderListId;
    @Column(name = "QTY")
    private Integer qty;
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")
    @ManyToOne
    private Orders orderId;
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCTID")
    @ManyToOne
    private Product productId;

    public OrderList() {
    }

    public OrderList(Integer qty, Orders orderId, Product productId) {
        this.qty = qty;
        this.orderId = orderId;
        this.productId = productId;
    }

    public OrderList(Integer orderListId) {
        this.orderListId = orderListId;
    }

    public Integer getOrderListId() {
        return orderListId;
    }

    public void setOrderListId(Integer orderListId) {
        this.orderListId = orderListId;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Orders getOrderId() {
        return orderId;
    }

    public void setOrderId(Orders orderId) {
        this.orderId = orderId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderListId != null ? orderListId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderList)) {
            return false;
        }
        OrderList other = (OrderList) object;
        if ((this.orderListId == null && other.orderListId != null) || (this.orderListId != null && !this.orderListId.equals(other.orderListId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OrderList[ orderListId=" + orderListId + " ]";
    }

}
