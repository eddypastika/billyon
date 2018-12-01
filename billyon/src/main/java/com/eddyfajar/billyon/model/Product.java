package com.eddyfajar.billyon.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author ig.eddy.p.putra
 * 
 * Nov 24, 2018 5:05:15 PM
 * @eddypastika
 */
@Entity
@Table(name="products")
public class Product extends AuditModel {
	
	@Id
	private Long id;
	
	private String image_path;
	private String name;
	private Integer stock;
	private Integer min_stock;
	private Integer display_price;
	private Integer actual_price;
	
	private Long store_id;
	private Long category_id;
	
	public Product(Long id, String image_path, String name, Integer stock, Integer min_stock, Integer display_price,
			Integer actual_price, Long store_id, Long category_id) {
		this.id = id;
		this.image_path = image_path;
		this.name = name;
		this.stock = stock;
		this.min_stock = min_stock;
		this.display_price = display_price;
		this.actual_price = actual_price;
		this.store_id = store_id;
		this.category_id = category_id;
	}

	public Product() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getMin_stock() {
		return min_stock;
	}

	public void setMin_stock(Integer min_stock) {
		this.min_stock = min_stock;
	}

	public Integer getDisplay_price() {
		return display_price;
	}

	public void setDisplay_price(Integer display_price) {
		this.display_price = display_price;
	}

	public Integer getActual_price() {
		return actual_price;
	}

	public void setActual_price(Integer actual_price) {
		this.actual_price = actual_price;
	}

	public Long getStore_id() {
		return store_id;
	}

	public void setStore_id(Long store_id) {
		this.store_id = store_id;
	}

	public Long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}
}
