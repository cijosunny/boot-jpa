package com.boot.jpa.service;

import com.boot.jpa.model.BootModel;

public interface BootService {
	public BootModel getBootJPA(Integer id);
	public BootModel saveBootJPA(BootModel bootModel);
}
