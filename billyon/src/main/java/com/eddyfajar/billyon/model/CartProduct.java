package com.eddyfajar.billyon.model;

/*
 * Developed by I Gede Eddy Pastika Putra on 12/8/18 4:07 PM
 * Last modified 12/8/18 4:07 PM
 * PC ig.eddy.p.putra
 * Comment: Model for table cart_products
 * Copyright (c) 2018. All rights reserved
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cart_products")
public class CartProduct extends AuditModel {

    @Id
    private Long id;

    private Long product_id;
    private Long cart_id;
    private int quantity;

    public CartProduct() {
    }

    public CartProduct(long id, long product_id, long cart_id, int quantity) {
        this.id = id;
        this.product_id = product_id;
        this.cart_id = cart_id;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public long getCart_id() {
        return cart_id;
    }

    public void setCart_id(long user_id) {
        this.cart_id = user_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
