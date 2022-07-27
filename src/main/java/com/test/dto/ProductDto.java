package com.test.dto;

public class ProductDto {

	private int id;

	private String name;

	private String colour;

	private int price;

	public ProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDto(int id, String name, String colour, int price) {
		super();
		this.id = id;
		this.name = name;
		this.colour = colour;
		this.price = price;
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

}