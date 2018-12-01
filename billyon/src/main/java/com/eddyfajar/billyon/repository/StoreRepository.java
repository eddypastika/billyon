package com.eddyfajar.billyon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eddyfajar.billyon.model.Store;
import com.eddyfajar.billyon.model.User;

/**
 * @author ig.eddy.p.putra
 * 
 * Nov 24, 2018 2:02:50 PM
 * @eddypastika
 */

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

	//List stores by user id
	@Query(value="SELECT * FROM stores s WHERE s.is_active = 1 and s.user_id = :user_id", nativeQuery=true)
	List<Store> userStores(@Param("user_id") Long user_id);
	
}
