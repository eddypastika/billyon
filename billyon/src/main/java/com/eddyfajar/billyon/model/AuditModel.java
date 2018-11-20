package com.eddyfajar.billyon.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
		value = {"created_dt", "updated_dt"},
		allowGetters = true
)
public abstract class AuditModel implements Serializable {
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_dt", nullable = false, updatable = false)
	@CreatedDate
	private Date created_dt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_dt", nullable = false, updatable = true)
	@LastModifiedDate
	private Date updated_dt;
	
	@Column(name = "is_active", nullable = false , updatable = true)
	private Integer is_active;

	public Date getCreated_dt() {
		return created_dt;
	}

	public void setCreated_dt(Date created_dt) {
		this.created_dt = created_dt;
	}

	public Date getUpdated_dt() {
		return updated_dt;
	}

	public void setUpdated_dt(Date updated_dt) {
		this.updated_dt = updated_dt;
	}

	public Integer getIs_active() {
		return is_active;
	}

	public void setIs_active(Integer is_active) {
		this.is_active = is_active;
	}
	
}
