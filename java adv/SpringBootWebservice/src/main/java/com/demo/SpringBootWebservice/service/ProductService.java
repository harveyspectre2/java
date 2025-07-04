package com.demo.SpringBootWebservice.service;

import java.util.List;

import com.demo.SpringBootWebservice.dto.ProductDTO;





public interface ProductService {

	List<ProductDTO> getAllProduct();
	ProductDTO getById(int pid);
	void deleteProduct(int pid);
	void saveProduct(ProductDTO product);
	boolean updateProduct(ProductDTO product);
	List<ProductDTO> getByPrice(float lowprice, float highprice);

	

}
