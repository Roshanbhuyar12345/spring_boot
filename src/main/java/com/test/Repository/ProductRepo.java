package com.test.repository;

  

import org.springframework.data.domain.Page; 
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.dto.ProductDto;
import com.test.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {

//	@Query(value = "SELECT * FROM Product e WHERE e.is_active=true",nativeQuery = true)
 	@Query(value = "select new com.test.dto.ProductDto(d.id, d.name, d.colour, d.price) from Product d")
    Page<ProductDto> findByOrderById(Pageable paging,Class<ProductDto> ProductDto);
	
//	@Query(value = "SELECT * FROM Product e WHERE e.is_active=false AND e.product_name=:name",nativeQuery = true)
	Page<ProductDto> findByName(@Param("name") String name,Pageable paging,Class<ProductDto> ProductDto);
	 
	//Product findByIdAndIsActiveTrue(Integer id);
}
