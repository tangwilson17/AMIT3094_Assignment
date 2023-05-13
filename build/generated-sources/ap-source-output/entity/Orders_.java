package entity;

import entity.Customer;
import entity.Payment;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-05-13T11:58:27")
@StaticMetamodel(Orders.class)
public class Orders_ { 

    public static volatile SingularAttribute<Orders, String> addressLineTwo;
    public static volatile SingularAttribute<Orders, Integer> orderId;
    public static volatile SingularAttribute<Orders, Payment> paymentId;
    public static volatile SingularAttribute<Orders, String> addressLineOne;
    public static volatile SingularAttribute<Orders, Customer> customerId;
    public static volatile SingularAttribute<Orders, Integer> status;

}