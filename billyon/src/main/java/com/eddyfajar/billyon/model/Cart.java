package com.eddyfajar.billyon.model;

/*
 * Developed by I Gede Eddy Pastika Putra on 12/8/18 4:06 PM
 * Last modified 12/8/18 4:00 PM
 * PC ig.eddy.p.putra
 * Comment: Model for table cart
 * Copyright (c) 2018. All rights reserved
 */

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "carts")
public class Cart extends AuditModel {

    @Id
    private Long id;

    private Long user_id;

    private int is_finished;

    public Cart() {
    }

    public Cart(long id, long user_id, int is_finished) {
        this.id = id;
        this.user_id = user_id;
        this.is_finished = is_finished;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public int getIs_finished() {
        return is_finished;
    }

    @Value("${defval.isfinished}")
    public void setIs_finished(int is_finished) {
        this.is_finished = is_finished;
    }
}
