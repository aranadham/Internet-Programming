package model;

import java.io.Serializable;

public class Product implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	String name,description,image;
	double price;
	
	public Product() {}

	public Product(String name, String description, String image, double price) {
		super();
		this.name = name;
		this.description = description;
		this.image = image;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
