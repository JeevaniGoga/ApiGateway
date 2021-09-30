package com.kethan.model;

public class CatalogItems {

	
	private String name;
	private String descrption;
	private int rating;

	public CatalogItems() {

	}

	public CatalogItems(String name, String descrption, int rating) {
		super();
		this.name = name;
		this.descrption = descrption;
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescrption() {
		return descrption;
	}

	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}
