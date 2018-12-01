package com.eddyfajar.billyon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eddyfajar.billyon.model.Product;

/**
 * @author ig.eddy.p.putra
 * 
 * Dec 1, 2018 7:22:24 PM
 * @eddypastika
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
