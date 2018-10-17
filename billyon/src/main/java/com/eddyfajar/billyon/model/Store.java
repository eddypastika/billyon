package com.eddyfajar.billyon.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "lst_store")
public class Store extends AuditModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long store_id;
	
	@NotNull
	@Size(max = 30)
	private String store_name;
	
	@NotNull
	@Size(max = 200)
	private String store_address;
	
	@Size(max = 15)
	private String store_lat;
	
	@Size(max = 15)
	private String store_long;
	
	@NotNull
	@Size(max = 15)
	private String store_phone;
	
	@NotNull
	@Size(max = 50)
	private String store_email;
	
	@NotNull
	@Size(max = 30)
	private String store_type;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private User user;

	public Long getStore_id() {
		return store_id;
	}

	public void setStore_id(Long store_id) {
		this.store_id = store_id;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public String getStore_address() {
		return store_address;
	}

	public void setStore_address(String store_address) {
		this.store_address = store_address;
	}

	public String getStore_lat() {
		return store_lat;
	}

	public void setStore_lat(String store_lat) {
		this.store_lat = store_lat;
	}

	public String getStore_long() {
		return store_long;
	}

	public void setStore_long(String store_long) {
		this.store_long = store_long;
	}

	public String getStore_phone() {
		return store_phone;
	}

	public void setStore_phone(String store_phone) {
		this.store_phone = store_phone;
	}

	public String getStore_email() {
		return store_email;
	}

	public void setStore_email(String store_email) {
		this.store_email = store_email;
	}

	public String getStore_type() {
		return store_type;
	}

	public void setStore_type(String store_type) {
		this.store_type = store_type;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
