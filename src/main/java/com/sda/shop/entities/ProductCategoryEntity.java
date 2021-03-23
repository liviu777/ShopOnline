package com.sda.shop.entities;

import org.hibernate.mapping.Join;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="product_categories")
public class ProductCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productCategoryId;


    @Size(min = 2, max= 7, message = "Your description is too long or too short. Please try again.")
    @NotBlank( message = "Your description cannot be blank.")
    private String description;

    @OneToMany(mappedBy = "productCategory")
    private List<ProductEntity> products;

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

    public Integer getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Integer productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
