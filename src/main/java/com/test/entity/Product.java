package com.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.test.dto.ProductDto;

@Entity
@Where(clause = "is_active=true")
@SQLDelete(sql = "UPDATE product SET is_active=false WHERE product_id=?")
@Projection(name = "Product", types = { ProductDto.class })
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	@Value("#{target.product_id}")
	private int id;

	@Column(name = "product_name")
	@Value("#{target.name}")
	private String name;

	@Column(name = "product_colour")
	@Value("#{target.colour}")
	private String colour;

	@Column(name = "product_price")
	@Value("#{target.price}")
	private int price;

	@Column(name = "is_active")
	private boolean isActive = true;

	public Product() {
		super();

	}

	public Product(int id, String name, String colour, int price, boolean isActive) {
		super();
		this.id = id;
		this.name = name;
		this.colour = colour;
		this.price = price;
		this.isActive = isActive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", colour=" + colour + ", price=" + price + "]";
	}

}
