package com.pms.models.repository;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pms.models.dtos.Product;
import com.pms.utilities.DbUtility;
import com.pms.utilities.SqlQueries;

@Repository
public class ProductRepository implements RepositoryContract<Product, Integer> {

	@Override
	public List<Product> getRecords() throws ClassNotFoundException, SQLException, Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet records = null;
		List<Product> products = null;

		try {
			connection = DbUtility.createConnection();
			statement = connection.createStatement();
			String query = SqlQueries.GET_ALL_PRODUCTS;
			records = statement.executeQuery(query);
			if (records != null) {
				products = new ArrayList<>();
				while (records.next()) {
					int product_id = records.getInt("product_id");
					String product_name = records.getString("product_name");
					double price = records.getDouble("price");
					String description = records.getString("description");
					String product_code = records.getString("product_code");
					String release_date = records.getString("release_date");
					String image_url = records.getString("image_url");
					double star_rating = records.getDouble("star_rating");
					Product product = new Product(product_id, product_name, price, description, product_code,
							release_date, image_url, star_rating);
					products.add(product);
				}
				;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return products;
	}

	@Override
	public Product getRecord(Integer id) throws ClassNotFoundException, SQLException, Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet records = null;
		Product product = null;

		try {
			connection = DbUtility.createConnection();
			String query = SqlQueries.GET_PRODUCT;
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			records = statement.executeQuery();
			if (records != null) {
				while (records.next()) {
					int product_id = records.getInt("product_id");
					String product_name = records.getString("product_name");
					double price = records.getDouble("price");
					String description = records.getString("description");
					String product_code = records.getString("product_code");
					String release_date = records.getString("release_date");
					String image_url = records.getString("image_url");
					double star_rating = records.getDouble("star_rating");
					product = new Product(product_id, product_name, price, description, product_code, release_date,
							image_url, star_rating);
				}
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return product;
	}

	@Override
	public Integer addRecord(Product product) throws ClassNotFoundException, SQLException, Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		Integer result = null;

		try {
			connection = DbUtility.createConnection();
			String query = SqlQueries.INSERT_PRODUCT;
			statement = connection.prepareStatement(query);
			statement.setInt(1, product.getProduct_id());
			statement.setString(2, product.getProduct_name());
			statement.setDouble(3, product.getPrice());
			statement.setString(4, product.getDescription());
			statement.setString(5, product.getProduct_code());
			statement.setString(6, product.getRelease_date());
			statement.setString(7, product.getImage_url());
			statement.setDouble(8, product.getStar_rating());

			result = statement.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}  finally {
			if (connection != null) {
				connection.close();
			}
		}
		return result;
	}

	@Override
	public Integer updateRecord(Product product, Integer id) throws ClassNotFoundException, SQLException, Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		String query = SqlQueries.UPDATE_PRODUCT;
		Integer result = null;

		try {
			connection = DbUtility.createConnection();

			statement = connection.prepareStatement(query);
			Product oldProductData = getRecord(id);

			if (product.getProduct_name() != null) {
				statement.setString(1, product.getProduct_name());
			} else {
				statement.setString(1, oldProductData.getProduct_name());
			}

			if (product.getPrice() != 0) {
				statement.setDouble(2, product.getPrice());
			} else {
				statement.setDouble(2, oldProductData.getPrice());
			}

			if (product.getDescription() != null) {
				statement.setString(3, product.getDescription());
			} else {
				statement.setString(3, oldProductData.getDescription());
			}

			if (product.getProduct_code() != null) {
				statement.setString(4, product.getProduct_code());
			} else {
				statement.setString(4, oldProductData.getProduct_code());
			}

			if (product.getRelease_date() != null) {
				statement.setString(5, product.getRelease_date());
			} else {
				statement.setString(5, oldProductData.getRelease_date());
			}

			if (product.getImage_url() != null) {
				statement.setString(6, product.getImage_url());
			} else {
				statement.setString(6, oldProductData.getImage_url());
			}

			if (product.getStar_rating() != 0) {
				statement.setDouble(7, product.getStar_rating());
			} else {
				statement.setDouble(7, oldProductData.getStar_rating());
			}

			statement.setInt(8, id);
			result = statement.executeUpdate();
			

		} catch (ClassNotFoundException e) {
			throw e;
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
		return result;
	}

	@Override
	public Integer deleteRecord(Integer id) throws ClassNotFoundException, SQLException, Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		String query = SqlQueries.DELETE_PRODUCT;
		Integer result = null;

		try {
			connection = DbUtility.createConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			result = statement.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw e;
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
		return result;
	}

}
