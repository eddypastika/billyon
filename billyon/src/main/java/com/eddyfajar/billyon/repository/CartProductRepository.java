package com.eddyfajar.billyon.repository;

/*
 * Developed by I Gede Eddy Pastika Putra on 12/8/18 4:20 PM
 * Last modified 12/8/18 4:20 PM
 * PC ig.eddy.p.putra
 * Comment: Repository class for Cart Product
 * Copyright (c) 2018. All rights reserved
 */

import com.eddyfajar.billyon.model.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartProductRepository extends JpaRepository<CartProduct, Long> {
}
