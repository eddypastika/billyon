package com.eddyfajar.billyon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eddyfajar.billyon.model.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

	//List<Store> findByUserId(Long user_id);
}
