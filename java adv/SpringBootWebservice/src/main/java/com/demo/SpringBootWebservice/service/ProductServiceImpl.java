package com.demo.SpringBootWebservice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.SpringBootWebservice.dao.ProductDao;
import com.demo.SpringBootWebservice.dto.ProductDTO;
import com.demo.SpringBootWebservice.mapper.ProductDTOMapper;
import com.demo.SpringBootWebservice.model.Product;



@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
	ProductDao pdao;

	public List<ProductDTO> getAllProduct() {
		List<Product> plist= pdao.findAll();
		List<ProductDTO> newplist=plist.stream()
				        .map(prod->ProductDTOMapper.maptoProductDTO(prod))
				        .collect(Collectors.toList());
		return newplist;
	}
	
	//@Override
	public ProductDTO getById(int pid) {
			Optional<Product> ob= pdao.findById(pid);
			if(ob.isPresent()) {
				Product p=ob.get();
			    return ProductDTOMapper.maptoProductDTO(p);
			 }
			return null;
		}
	
	//@Override
	public void deleteProduct(int pid) {
		pdao.deleteById(pid);
		
	}
	
	//@Override
	public void saveProduct(ProductDTO pdto) {
		Product product=ProductDTOMapper.mapToProduct(pdto);
		pdao.save(product);
		
	}

	

	//@Override
	public boolean updateProduct(ProductDTO pdto) {
		Product product=ProductDTOMapper.mapToProduct(pdto);
		Optional<Product> ob= pdao.findById(product.getPid());
		if(ob.isPresent()) {
			Product p=ob.get();
			p.setPname(product.getPname());
			p.setQty(product.getQty());
			p.setPrice(product.getPrice());
			p.setMfgdate(product.getMfgdate());
			pdao.save(p);
			return true;
		}
		return false;
		
	}

	@Override
	public List<ProductDTO> getByPrice(float lowprice, float highprice) {
		List<Product> plist=pdao.findByPrice(lowprice, highprice);
		List<ProductDTO> newplist=plist.stream()
		        .map(prod->ProductDTOMapper.maptoProductDTO(prod))
		        .collect(Collectors.toList());
		return newplist;
	}

	
}
