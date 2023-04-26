package com.example.tinexchain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
public class Category {

    @Id
    private long category_Id;

    private String category_name;

    @ManyToOne
    @JoinColumn(name="sur_category_id")
    private Category category;

    @OneToMany(mappedBy="category")
    private List<Category> sur_categories;

    @ManyToMany
    @JsonIgnoreProperties(value = "productList")
    @JoinTable(
            name = "belongs_to",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> productList;

    public Category(long category_Id, String category_name) {
        this.category_Id = category_Id;
        this.category_name = category_name;
    }

    public Category() {

    }

     @Override
         public String toString() {
             return this.category_name;
         }







}
