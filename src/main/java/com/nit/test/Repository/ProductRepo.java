package com.nit.test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.nit.test.Entity.Products;



@Repository
public interface ProductRepo extends JpaRepository<Products, Integer>{

}
