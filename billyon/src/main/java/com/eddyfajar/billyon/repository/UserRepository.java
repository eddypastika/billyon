package com.eddyfajar.billyon.repository;

import org.json.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eddyfajar.billyon.model.User;

/**
 * @author ig.eddy.p.putra
 * 
 * Nov 24, 2018 2:04:02 PM
 * @eddypastika
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value="SELECT * FROM users u WHERE u.email = :email and u.password = :password", nativeQuery=true)
	User loginUser(@Param("email") String email, @Param("password") String password);
	
}
