package entity;

import entity.Orders;
import entity.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-05-13T11:58:27")
@StaticMetamodel(OrderList.class)
public class OrderList_ { 

    public static volatile SingularAttribute<OrderList, Integer> orderListId;
    public static volatile SingularAttribute<OrderList, Product> productId;
    public static volatile SingularAttribute<OrderList, Orders> orderId;
    public static volatile SingularAttribute<OrderList, Integer> qty;

}