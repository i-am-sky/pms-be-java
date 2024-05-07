package com.pms.utilities;

public class SqlQueries {
	public final static String GET_ALL_PRODUCTS = "SELECT * FROM PRODUCTS";
	public final static String GET_PRODUCT = "SELECT * FROM PRODUCTS WHERE product_id=?";
	public final static String INSERT_PRODUCT = "INSERT INTO PRODUCTS(product_id, product_name, price, description, product_code, release_date, image_url, star_rating) VALUES (?,?,?,?,?,?,?,?)";
	public final static String UPDATE_PRODUCT = "UPDATE PRODUCTS SET product_name=?, price=?, description=?, product_code=?, release_date=?, image_url=?, star_rating=? WHERE product_id=? ";
	public final static String DELETE_PRODUCT = "DELETE FROM PRODUCTS WHERE product_id=? ";

}
