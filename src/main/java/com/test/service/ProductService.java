package com.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.Repository.ProductRepo;
import com.test.dto.ProductDto;
import com.test.entity.Product;
import com.test.exception.ResourceNotFoundException;
import com.test.utility.Pegination;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	// Post The Data
	public ProductDto addProduct(ProductDto productDto) {

	Product product=this.dtotoProduct(productDto);
	Product saveproduct=this.productRepo.save(product);
	return this.producttoDto(saveproduct);

	}

	// reading all the data from database by using peginations
	public Page<ProductDto> getAllProduct(String search, String from, String to) {

		Pageable paging = new Pegination().getPagination(from, to);

		if ((search == "") || (search == null) || (search.length() == 0)) {
			return productRepo.findByOrderById(paging, ProductDto.class);
		} else {
			return productRepo.findByName(search, paging, ProductDto.class);

		}
	} 

	// Read By Id
	public ProductDto getById(int id) {

		Product product = this.productRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("resource is not found"));
		
		return this.producttoDto(product);

	}

	// updating
	public ProductDto update(ProductDto productDto, int id)     {
	Product product= productRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("resouce not found for update"));
	
	product.setId(productDto.getId());
	product.setName(productDto.getName());
	product.setColour(productDto.getColour());
	product.setPrice(productDto.getPrice());
	
	Product updatedproduct=productRepo.save(product);
	
	ProductDto productDto2=this.producttoDto(updatedproduct);
	
	return productDto2;
	
	}

	// delete operation
	public void deleteProduct(int id) {

	this.productRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not available for deletion"));

    this.productRepo.deleteById(id);

		

	}
	
	//ProductDto To Product
	public Product dtotoProduct(ProductDto productDto) {
		
		Product product=this.modelMapper.map(productDto,Product.class);
		return product;
		
		
	}
	
	//Product To ProductDto
	public ProductDto producttoDto(Product product) {
		ProductDto productDto=this.modelMapper.map(product,ProductDto.class);
		return productDto;
	}
	
	
	

}
