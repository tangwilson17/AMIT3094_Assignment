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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mayte
 */
@Entity
@Table(name = "PRODUCT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByProductid", query = "SELECT p FROM Product p WHERE p.productid = :productid"),
    @NamedQuery(name = "Product.findByProductname", query = "SELECT p FROM Product p WHERE p.productname = :productname"),
    @NamedQuery(name = "Product.findByDescription", query = "SELECT p FROM Product p WHERE p.description = :description"),
    @NamedQuery(name = "Product.findByPrice", query = "SELECT p FROM Product p WHERE p.price = :price"),
    @NamedQuery(name = "Product.findByStatus", query = "SELECT p FROM Product p WHERE p.status = :status"),
    @NamedQuery(name = "Product.findByQty", query = "SELECT p FROM Product p WHERE p.qty = :qty"),

    @NamedQuery(name = "Product.searchProductsID", query = "SELECT p FROM Product p WHERE p.productid = :searchProdID"),
    @NamedQuery(name = "Product.searchProductsName", query = "SELECT p FROM Product p WHERE p.productname LIKE :searchProdName"),

    @NamedQuery(name = "Product.filterASC", query = "SELECT p FROM Product p ORDER BY p.price ASC"),
    @NamedQuery(name = "Product.filterDESC", query = "SELECT p FROM Product p ORDER BY p.price DESC"),
    @NamedQuery(name = "Product.filterAZ", query = "SELECT p FROM Product p ORDER BY p.productname ASC"),
    @NamedQuery(name = "Product.filterZA", query = "SELECT p FROM Product p ORDER BY p.productname DESC"),

    @NamedQuery(name = "Product.filterASCOnSearchID", query = "SELECT p FROM Product p WHERE p.productid = :searchProdID ORDER BY p.price ASC"),
    @NamedQuery(name = "Product.filterASCOnSearchName", query = "SELECT p FROM Product p WHERE p.productname LIKE :searchProdName ORDER BY p.price ASC"),
    @NamedQuery(name = "Product.filterDESCOnSearchID", query = "SELECT p FROM Product p WHERE p.productid = :searchProdID ORDER BY p.price DESC"),
    @NamedQuery(name = "Product.filterDESCOnSearchName", query = "SELECT p FROM Product p WHERE p.productname LIKE :searchProdName ORDER BY p.price DESC"),
    @NamedQuery(name = "Product.filterAZOnSearchID", query = "SELECT p FROM Product p WHERE p.productid = :searchProdID ORDER BY p.productname ASC"),
    @NamedQuery(name = "Product.filterAZOnSearchName", query = "SELECT p FROM Product p WHERE p.productname LIKE :searchProdName ORDER BY p.productname ASC"),
    @NamedQuery(name = "Product.filterZAOnSearchID", query = "SELECT p FROM Product p WHERE p.productid = :searchProdID ORDER BY p.productname DESC"),
    @NamedQuery(name = "Product.filterZAOnSearchName", query = "SELECT p FROM Product p WHERE p.productname LIKE :searchProdName ORDER BY p.productname DESC"),

    @NamedQuery(name = "Product.priceRange", query = "SELECT p FROM Product p WHERE p.price BETWEEN :minNum AND :maxNum"),

    @NamedQuery(name = "Product.BrowseCategory", query = "SELECT p FROM Product p WHERE p.categorycode.categoryid = :categoryID"),
    @NamedQuery(name = "Product.filterASCOnCategory", query = "SELECT p FROM Product p WHERE p.categorycode.categoryid = :categoryID ORDER BY p.price ASC"),
    @NamedQuery(name = "Product.filterDESCOnCategory", query = "SELECT p FROM Product p WHERE p.categorycode.categoryid = :categoryID ORDER BY p.price DESC"),
    @NamedQuery(name = "Product.filterAZOnCategory", query = "SELECT p FROM Product p WHERE p.categorycode.categoryid = :categoryID ORDER BY p.productname ASC"),
    @NamedQuery(name = "Product.filterZAOnCategory", query = "SELECT p FROM Product p WHERE p.categorycode.categoryid = :categoryID ORDER BY p.productname DESC")})

public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PRODUCTID")
    private Integer productid;
    @Size(max = 50)
    @Column(name = "PRODUCTNAME")
    private String productname;
    @Size(max = 500)
    @Column(name = "DESCRIPTION")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICE")
    private Double price;
    @Column(name = "STATUS")
    private Integer status;
    @Lob
    @Column(name = "PRODUCTIMAGE")
    private byte[] productimage;
    @Column(name = "QTY")
    private Integer qty;
    @JoinColumn(name = "CATEGORYCODE", referencedColumnName = "CATEGORYID")
    @ManyToOne(optional = false)
    private Category categorycode;

    public Product() {
    }

    public Product(Integer productid) {
        this.productid = productid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public byte[] getImage() {
        return productimage;
    }

    public void setImage(byte[] image) {
        this.productimage = image;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Category getCategorycode() {
        return categorycode;
    }

    public void setCategorycode(Category categorycode) {
        this.categorycode = categorycode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productid != null ? productid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.productid == null && other.productid != null) || (this.productid != null && !this.productid.equals(other.productid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Product[ productid=" + productid + " ]";
    }

}
