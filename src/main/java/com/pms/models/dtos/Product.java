package com.pms.models.dtos;

public class Product {
	private int product_id = 0;
	private String product_name = "";
	private double price = 0;
	private String description = "";
	private String product_code = "";
	private String release_date = "";
	private String image_url = "";
	private double star_rating = 0;

	// constructors
	public Product() {
	}

	public Product(int product_id, String product_name, double price, String description, String product_code,
			String release_date, String image_url, double star_rating) {
		this.product_id = product_id;
		this.product_name = product_name;
		this.price = price;
		this.description = description;
		this.product_code = product_code;
		this.release_date = release_date;
		this.image_url = image_url;
		this.star_rating = star_rating;
	}

	// except product_id
	public Product(String product_name, double price, String description, String product_code, String release_date,
			String image_url, double star_rating) {
		this.product_name = product_name;
		this.price = price;
		this.description = description;
		this.product_code = product_code;
		this.release_date = release_date;
		this.image_url = image_url;
		this.star_rating = star_rating;
	}

	// getters and setters
	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public double getStar_rating() {
		return star_rating;
	}

	public void setStar_rating(double star_rating) {
		this.star_rating = star_rating;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", price=" + price
				+ ", description=" + description + ", product_code=" + product_code + ", release_date=" + release_date
				+ ", image_url=" + image_url + ", star_rating=" + star_rating + "]";
	}

}
