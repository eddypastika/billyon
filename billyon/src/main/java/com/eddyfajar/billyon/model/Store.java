package com.eddyfajar.billyon.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "stores")
public class Store extends AuditModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String store_name;
	
	@NotNull
	private String address;
	
	private String latitude;

	private String longitude;
	
	@NotNull
	private String store_phone;
	
	@NotNull
	private String email;
	
	@NotNull
	private String store_type;
	
	public Store() {
	}

	public Store(Long id,String store_name, String address, String latitude, String longitude,
			String store_phone, String email, String store_type) {
		this.id = id;
		this.store_name = store_name;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.store_phone = store_phone;
		this.email = email;
		this.store_type = store_type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getStore_phone() {
		return store_phone;
	}

	public void setStore_phone(String store_phone) {
		this.store_phone = store_phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStore_type() {
		return store_type;
	}

	public void setStore_type(String store_type) {
		this.store_type = store_type;
	}
}
