package entity;

import entity.Category;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-05-13T11:58:27")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, Integer> productid;
    public static volatile SingularAttribute<Product, Category> categorycode;
    public static volatile SingularAttribute<Product, Double> price;
    public static volatile SingularAttribute<Product, Integer> qty;
    public static volatile SingularAttribute<Product, String> productname;
    public static volatile SingularAttribute<Product, String> description;
    public static volatile SingularAttribute<Product, byte[]> productimage;
    public static volatile SingularAttribute<Product, Integer> status;

}