package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.dto.ProductDto;
import com.test.dto.SuccessResponce;
import com.test.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/product")
	@PreAuthorize("hasRole('addProduct')")
	public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) {
		this.productService.addProduct(productDto);
		return new ResponseEntity(productDto, HttpStatus.CREATED);
	}

	@GetMapping("/product" )
//	@PreAuthorize("hasRole('getAllProduct')")
	public ResponseEntity<?> getAllProduct(
			@RequestParam(defaultValue = "") String search,
			@RequestParam(defaultValue = "1") String pageNo,
			@RequestParam(defaultValue = "10") String size) {
		Page<ProductDto> product = productService.getAllProduct(search, pageNo, size);

		if (product.getTotalElements() != 0) {

			return new ResponseEntity<>(new SuccessResponce("success", "success", product.getContent()), HttpStatus.OK);
		}
		return new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST);
	}

	// Read By Id
	@GetMapping("/product/{id}")
	@PreAuthorize("hasRole('getProductByID')")
	public ResponseEntity<?> getProduct(@PathVariable("id") int id) {

		return new ResponseEntity<>(new SuccessResponce("success", "success", productService.getById(id)),
				HttpStatus.OK);

	}

	@PutMapping("/product/{id}")
	@PreAuthorize("hasRole('editProduct')")
	public ResponseEntity<ProductDto> Update(@RequestBody ProductDto productDto, @PathVariable("id") int id) {
		ProductDto Updatedproduct = this.productService.update(productDto, id);
		return ResponseEntity.ok(Updatedproduct);
	}

	@DeleteMapping("/product/{id}")
	@PreAuthorize("hasRole('deleteProduct')")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		this.productService.deleteProduct(id);
		return ResponseEntity.ok("deleted succefully");
	}

}
