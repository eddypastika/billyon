package com.eddyfajar.billyon.model;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "user_menu")
public class Menu {
	
	@Id
	private Long id;
	
	private String menu_name;
	
	public Menu() {
	}

	public Menu(Long id, String menu_name) {
		this.id = id;
		this.menu_name = menu_name;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
}
