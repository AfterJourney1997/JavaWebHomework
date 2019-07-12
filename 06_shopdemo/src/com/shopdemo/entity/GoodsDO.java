package com.shopdemo.entity;

import java.util.UUID;

public class GoodsDO {

    private String id;
    private String name;
    private float price;
    private String description;
    private int category;
	
    public GoodsDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GoodsDO(String name, float price, String description, int category) {
		super();
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.price = price;
		this.description = description;
		this.category = category;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "GoodsDO [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description
				+ ", category=" + category + "]";
	}

}
