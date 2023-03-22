package com.nit.test.serviceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import com.nit.test.Entity.Products;
import com.nit.test.Exception.ResourceNotFoundException;
import com.nit.test.Repository.ProductRepo;
import com.nit.test.service.ProductService;

;

@Service
public class ProdctServicempl implements ProductService {

	@Autowired
	private ProductRepo productRepo;

	@Override
	public Products CreatePro(Products pro) {

		// to set arrival date and time of product
		LocalDateTime dateTime = LocalDateTime.now();
		pro.setArrivalTime(dateTime);
		
		
		LocalDateTime l1=dateTime.plusDays(pro.getShelfLife());
		pro.setExpirayDateTime(l1);

		Products Productsave = this.productRepo.save(pro);

		return Productsave;
	}

	@Override
	public Products updateProducts(Products pro, Integer productId) {

		Products pro1 = productRepo.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "Id", productId));

		pro1.setPro_name(pro.getPro_name());
		pro1.setPro_price(pro.getPro_price());
		pro1.setPro_Disc(pro.getPro_Disc());

		pro1.setShelfLife(pro.getShelfLife());

		Products saveUpdatedPro = this.productRepo.save(pro1);

		return saveUpdatedPro;
	}

	@Override
	public void deleteProducts(Integer productId) {

		Products proDelte = productRepo.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "Id", productId));

		productRepo.delete(proDelte);
	}

	@Override
	public List<Products> getAllProducts() {

		List<Products> products = productRepo.findAll();

		return products;
	}

	@Override
	public Products getSingleProduct(Integer productId) {

		Products product1 = productRepo.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "Id", productId));

		return product1;
	}

}
