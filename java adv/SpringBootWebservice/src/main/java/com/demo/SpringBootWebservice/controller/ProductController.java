package com.demo.SpringBootWebservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.SpringBootWebservice.dto.ProductDTO;
import com.demo.SpringBootWebservice.service.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService pservice;
	
	@GetMapping("/products")
	public ResponseEntity<List<ProductDTO>> getAllproducts(){
		List<ProductDTO> plist=pservice.getAllProduct();
		return ResponseEntity.ok(plist);
	}
	
	@GetMapping("/products/{pid}")
	public ResponseEntity<ProductDTO> getById(@PathVariable int pid){
		ProductDTO prod=pservice.getById(pid);
		return ResponseEntity.ok(prod);
	}
	
	
	///    /product/products/50/200
	@GetMapping("/products/{lowprice}/{highprice}")
	public ResponseEntity<List<ProductDTO>> getByPrice(@PathVariable float lowprice,@PathVariable float highprice){
		List<ProductDTO> plist=pservice.getByPrice(lowprice,highprice);
		return ResponseEntity.ok(plist);
	}

	@DeleteMapping("/products/{pid}")
	public ResponseEntity<String> deleteById(@PathVariable int pid){
		pservice.deleteProduct(pid);
		return ResponseEntity.ok("data deleted successfully");
	}
	
	@PostMapping("/products/{pid}")
	public ResponseEntity<String> addproduct(@RequestBody ProductDTO p){
		pservice.saveProduct(p);
		return ResponseEntity.ok("data added successfully");
	}
	
	@PutMapping("/products/{pid}")
	public ResponseEntity<String> updateproduct(@RequestBody ProductDTO p){
		boolean status=pservice.updateProduct(p);
		if(status)
		    return ResponseEntity.ok("data updated successfully");
		else
			return ResponseEntity.status(500).body("not found");
			//return ResponseEntity.notFound().build();
	}
	
	
}
