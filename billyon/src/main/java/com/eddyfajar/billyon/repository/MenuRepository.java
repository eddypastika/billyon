package com.eddyfajar.billyon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eddyfajar.billyon.model.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
	
	@Query(value="select um.id, um.menu_name "
			+ " from user_role_menu urm, user_menu um, users u "
			+ "where urm.role_id = :role_id and urm.menu_id = um.id;", nativeQuery=true)
	List<Menu> listUserMenus(@Param("role_id") Integer role_id);

}
