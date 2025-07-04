package com.demo.SpringBootWebservice.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.demo.SpringBootWebservice.dto.ProductDTO;
import com.demo.SpringBootWebservice.model.Product;



public class ProductDTOMapper {
	
 public static ProductDTO maptoProductDTO(Product p) {
	 String ldt=p.getMfgdate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	return new ProductDTO(p.getPid(),p.getPname(),p.getQty(),p.getPrice(),ldt); 
	 
 }
 
 public static Product mapToProduct(ProductDTO pdto) {
	 LocalDate ldt=LocalDate.parse(pdto.getMfgdate(),DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	 return new Product(pdto.getPid(),pdto.getPname(),pdto.getQty(),pdto.getPrice(),ldt);
 }
	
}
