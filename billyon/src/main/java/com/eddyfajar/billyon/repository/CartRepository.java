package com.eddyfajar.billyon.repository;

/*
 * Developed by I Gede Eddy Pastika Putra on 12/8/18 4:17 PM
 * Last modified 12/8/18 4:17 PM
 * PC ig.eddy.p.putra
 * Comment: Repository class for Cart
 * Copyright (c) 2018. All rights reserved
 */

import com.eddyfajar.billyon.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
