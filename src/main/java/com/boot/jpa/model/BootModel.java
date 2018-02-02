package com.boot.jpa.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class BootModel {
	@Id
	private Integer id;
	private String bootVersion;
	private String jpaVersion;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBootVersion() {
		return bootVersion;
	}
	public void setBootVersion(String bootVersion) {
		this.bootVersion = bootVersion;
	}
	public String getJpaVersion() {
		return jpaVersion;
	}
	public void setJpaVersion(String jpaVersion) {
		this.jpaVersion = jpaVersion;
	}
}
