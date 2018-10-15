package com.eddyfajar.billyon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eddyfajar.billyon.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
