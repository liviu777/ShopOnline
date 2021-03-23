package com.sda.shop.entities;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Size(min= 1, max= 10, message = "Your input is too short or too long. Please try again")
    @NotBlank(message = "Field cannot be blank")
    private String productName;

    @Size(min= 1, max= 25, message = "Your input is too short or too long. Please try again")
    @NotBlank(message = "Field cannot be blank")
    private String productDescription;


    @Min(value =1, message = "Not a valid input price")
    @Max(value = 4, message=" Input price is too big")
    private Double price;


    @Min(value = 1, message = "CANNOT BE EMPTY")
    @Max(value = 4, message=" Input STOCK DIGIT is too large")
    private Integer productStock;

    @ManyToOne
    @JoinColumn(name= "productCategoryId", insertable = false, updatable = false)
    private ProductCategoryEntity productCategory;
///sa nu avem problema cu mai sus, sa aiba doua coloane de prdduct category ID . si daca il setam false, el o sa ignore la salvare coloana si va face o relatie cu ce e mai sus pt info.
    private Integer productCategoryId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Integer productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public ProductCategoryEntity getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategoryEntity productCategory) {
        this.productCategory = productCategory;
    }
}
