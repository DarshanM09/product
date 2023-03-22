package com.nit.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.Entity.Products;
import com.nit.Exceptions.ResourceNotFoundException;
import com.nit.Repository.ProductRepo;
import com.nit.service.ProductService;

@Service
public class ProdctServicempl implements ProductService {

	@Autowired
	private ProductRepo productRepo;

	@Override
	public Products CreatePro(Products pro) {

		Products Productsave = productRepo.save(pro);

		
		return Productsave;
	}

	@Override
	public Products updateProducts(Products pro, Integer productId) {

		Products pro1 = productRepo.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product", "Id", productId) );

		pro1.setPro_name(pro.getPro_name());
		pro1.setPro_price(pro.getPro_price());
		pro1.setPro_Disc(pro.getPro_Disc());
		pro1.setArrivalTime(pro.getArrivalTime());
		pro1.setShelfLife(pro.getShelfLife());
		
		Products saveUpdatedPro = productRepo.save(pro1);
		
		return saveUpdatedPro;
	}

	@Override
	public void deleteProducts(Integer productId) {


		Products proDelte = productRepo.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product", "Id", productId) );
		
		productRepo.delete(proDelte);
	}

	@Override
	public List<Products> getAllProducts() {


		List<Products> products = productRepo.findAll();
		
		return products;
	}

	@Override
	public Products getSingleProduct(Integer productId) {


		Products product1 = productRepo.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product", "Id", productId) );
		
		return product1;
	}
	
	
	
	
}
