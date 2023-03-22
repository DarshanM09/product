package com.nit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nit.Entity.Products;

@Repository
public interface ProductRepo extends JpaRepository<Products, Integer>{

}
