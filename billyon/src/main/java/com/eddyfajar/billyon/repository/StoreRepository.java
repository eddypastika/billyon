package com.eddyfajar.billyon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eddyfajar.billyon.model.Store;
import com.eddyfajar.billyon.model.User;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

	@Query(value="SELECT * FROM stores s WHERE s.user_id = :user_id", nativeQuery=true)
	List<Store> userStores(@Param("user_id") Long user_id);
}
