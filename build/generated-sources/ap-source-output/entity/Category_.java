package entity;

import entity.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-05-13T11:58:27")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile SingularAttribute<Category, String> categorydesc;
    public static volatile SingularAttribute<Category, String> categoryname;
    public static volatile SingularAttribute<Category, Integer> categoryid;
    public static volatile ListAttribute<Category, Product> productList;

}