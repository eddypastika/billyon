package com.eddyfajar.billyon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eddyfajar.billyon.model.Category;

/**
 * @author ig.eddy.p.putra
 * 
 * Nov 24, 2018 8:57:49 PM
 * @eddypastika
 */

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
