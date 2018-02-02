package com.boot.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.jpa.model.BootModel;
@Repository
public interface BootRepo extends JpaRepository<BootModel, Integer> {

}
