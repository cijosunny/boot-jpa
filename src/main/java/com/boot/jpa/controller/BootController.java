package com.boot.jpa.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BootController {
	@GetMapping("/get")
	public ResponseEntity<?> getBootJPA(){
		return ResponseEntity.ok().build();
	}
}
