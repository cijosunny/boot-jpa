package com.boot.jpa.model;

public class BootModel {
	private int id;
	private String bootVersion;
	private String jpaVersion;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
