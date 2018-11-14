package com.eddyfajar.billyon.model;

import java.util.List;

public class LoginResponse {
	
	private User users;
	private List<Menu> menus;
	private List<Store> stores;
	
	
	
	public LoginResponse() {
	}

	public LoginResponse(User users, List<Menu> menus, List<Store> stores) {
		this.users = users;
		this.menus = menus;
		this.stores = stores;
	}
	
	public User getUsers() {
		return users;
	}
	public void setUsers(User users) {
		this.users = users;
	}
	public List<Menu> getMenus() {
		return menus;
	}
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	public List<Store> getStores() {
		return stores;
	}
	public void setStores(List<Store> stores) {
		this.stores = stores;
	}
	
}
