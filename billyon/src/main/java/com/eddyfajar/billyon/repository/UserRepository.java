package com.eddyfajar.billyon.repository;

import org.json.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eddyfajar.billyon.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value="SELECT * FROM lst_user u WHERE u.user_name = :user_name and u.user_password = :user_password", nativeQuery=true)
	User loginUser(@Param("user_name") String username, @Param("user_password") String password);
	
}
