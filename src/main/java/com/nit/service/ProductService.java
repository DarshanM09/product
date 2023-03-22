package com.nit.service;

import java.util.List;

import com.nit.Entity.Products;

public interface ProductService {
	
	
	//save prodcuts
	 Products CreatePro(Products pro);

	//update Products
	 Products updateProducts(Products pro,Integer productId);
	
	
	//delete product
       void deleteProducts(Integer productId);
	
	//GetAll products
	List<Products>  getAllProducts();
	
	//singlepro 
	 Products getSingleProduct(Integer productId);
	
	
	
	
}
