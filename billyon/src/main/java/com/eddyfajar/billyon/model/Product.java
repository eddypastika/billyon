package com.eddyfajar.billyon.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author ig.eddy.p.putra
 * 
 * Nov 24, 2018 5:05:15 PM
 * @eddypastika
 */
@Entity
@Table(name="product")
public class Product extends AuditModel {
	
	private Long id;
	private String image_path;
	private String name;
	private Integer stock;
	private Integer min_stock;
	private Integer display_price;
	private Integer actual_price;
	private Integer need_synced;
	private Long store_id;
	private Long category_id;
	
	

}
