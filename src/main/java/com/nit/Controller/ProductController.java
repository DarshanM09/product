package com.nit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.Entity.Products;
import com.nit.service.ProductService;

import jakarta.persistence.criteria.CriteriaBuilder.In;

@RestController
@RequestMapping("/product/v1.0")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/keep")
	public ResponseEntity<Products> Createproducts(@RequestBody Products pro)
	{
		System.out.println("ProductController.Createproducts()");
		Products createPro = productService.CreatePro(pro);
		
		return new ResponseEntity<Products>(createPro, HttpStatus.CREATED);
	}

	@GetMapping("/Update/{pid}")
	public ResponseEntity<Products> UpdatePro(@RequestBody Products pro,@PathVariable Integer pid){
		
		Products updateProducts = productService.updateProducts(pro, pid);
		
		return new ResponseEntity<Products>(updateProducts,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{pid}")
	public ResponseEntity<ApiResponse> deleteProducts(@PathVariable Integer pid){
		
		productService.deleteProducts(pid);
		return new ResponseEntity<ApiResponse>((new ApiResponse("ProductdeletedSucessfully..",true)), HttpStatus.OK);
		
	}
	
	@GetMapping("/getallPro")
	public ResponseEntity<List<Products>> getAllPro(){
		
		List<Products> allProducts = productService.getAllProducts();
		
		
		return new ResponseEntity<List<Products>>(allProducts, HttpStatus.OK);
		
		
		
		
	}
	
	@GetMapping("/proDetail")
	public ResponseEntity<Products>SingleProduct(@PathVariable  Integer pid){
		Products singleProduct = productService.getSingleProduct(pid);
		
		return new ResponseEntity<Products>(singleProduct, HttpStatus.OK);
		
	}
	
}
