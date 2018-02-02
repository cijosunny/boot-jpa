package com.boot.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.jpa.model.BootModel;
import com.boot.jpa.service.BootService;

@RestController
public class BootController {
	@Autowired
	BootService bootService;
	
	@GetMapping("/get")
	public ResponseEntity<?> getBootJPA(@RequestParam("id") Integer id){
		BootModel bootModel = bootService.getBootJPA(id);
		if(bootModel != null){
			return ResponseEntity.ok(bootModel);
		}
		else{
			return ResponseEntity.ok().build();
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveBootJPA(@RequestBody BootModel bootModel){
		return ResponseEntity.ok(bootService.saveBootJPA(bootModel));
	}
}
