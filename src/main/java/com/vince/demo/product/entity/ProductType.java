package com.vince.demo.product.entity;

import javax.persistence.Table;

@Table(name = "product_type")
public class ProductType {
    private Integer id;
    private String name;
    private Integer state;

    public ProductType(Integer id, String name, Integer state) {
        this.id = id;
        this.name = name;
        this.state = state;
    }

    public ProductType() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
