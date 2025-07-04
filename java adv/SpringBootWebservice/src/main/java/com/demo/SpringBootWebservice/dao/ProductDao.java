package com.demo.SpringBootWebservice.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import com.demo.SpringBootWebservice.model.Product;

@Repository
public interface ProductDao extends JpaRepository<Product,Integer>{

	
	//@Query(value="select p from Product where price between :lpr and :hpr")
	@Query(value="select * from product where price between :lpr and :hpr",nativeQuery = true)
	List<Product> findByPrice(float lpr, float hpr);
	
	@Procedure(procedureName = "getCount")
	public int getCount();

}
