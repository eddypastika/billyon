package com.eddyfajar.billyon.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * @author ig.eddy.p.putra
 * 
 * Nov 24, 2018 4:53:57 PM
 * @eddypastika
 */

@Entity
@Table(name="category")
public class Category extends AuditModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String category_name;
	
	private String image_path;
	
	private Long store_id;

	public Category(Long id, String category_name, String image_path, Long store_id) {
		this.id = id;
		this.category_name = category_name;
		this.image_path = image_path;
		this.store_id = store_id;
	}

	public Category() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public Long getStore_id() {
		return store_id;
	}

	public void setStore_id(Long store_id) {
		this.store_id = store_id;
	}
}
