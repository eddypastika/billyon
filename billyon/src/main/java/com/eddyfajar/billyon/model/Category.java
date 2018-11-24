package com.eddyfajar.billyon.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author ig.eddy.p.putra
 * 
 * Nov 24, 2018 4:53:57 PM
 * @eddypastika
 */

@Entity
@Table(name="category")
public class Category extends AuditModel {
	
	private Long id;
	private String category_name;
	private String image_path;
	private Integer need_synced;
	private Long store_id;

}
