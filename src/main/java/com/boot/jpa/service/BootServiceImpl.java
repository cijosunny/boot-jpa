package com.boot.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.jpa.model.BootModel;
import com.boot.jpa.repository.BootRepo;

@Service
public class BootServiceImpl implements BootService{
	@Autowired
	BootRepo bootRepo;
	
	public BootModel getBootJPA(Integer id){
		return bootRepo.findOne(id);
	}
	
	public BootModel saveBootJPA(BootModel bootModel){
		return bootRepo.save(bootModel);
	}
}
