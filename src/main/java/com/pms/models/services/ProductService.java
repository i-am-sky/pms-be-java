package com.pms.models.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.models.dtos.Product;
import com.pms.models.repository.RepositoryContract;

@Service
public class ProductService implements ServiceContract<Product, Integer> {

	@Autowired
	private RepositoryContract<Product, Integer> _repository;

	@Override
	public List<Product> fetchRecords(int sortingChoice) throws ClassNotFoundException, SQLException, Exception {
		List<Product> sortedProductRecords = null;
		List<Product> products = _repository.getRecords();
		try {
			switch (sortingChoice) {
			case 1: {
				sortedProductRecords = products.stream()
						.sorted((e1, e2) -> Integer.compare(e1.getProduct_id(), e2.getProduct_id())).toList();
				break;
			}

			case 2: {
				sortedProductRecords = products.stream()
						.sorted((e1, e2) -> e1.getProduct_name().compareTo(e2.getProduct_name())).toList();
				break;
			}

			case 3: {
				sortedProductRecords = products.stream()
						.sorted((e1, e2) -> Double.compare(e1.getPrice(), e2.getPrice())).toList();
				break;
			}
			case 4: {
				sortedProductRecords = products.stream()
						.sorted((e1, e2) -> e1.getDescription().compareTo(e2.getDescription())).toList();
				break;
			}
			case 5: {
				sortedProductRecords = products.stream()
						.sorted((e1, e2) -> e1.getProduct_code().compareTo(e2.getProduct_code())).toList();
				break;
			}
			case 6: {
				sortedProductRecords = products.stream()
						.sorted((e1, e2) -> e1.getRelease_date().compareTo(e2.getRelease_date())).toList();
				break;
			}
			case 7: {
				sortedProductRecords = products.stream()
						.sorted((e1, e2) -> e1.getImage_url().compareTo(e2.getImage_url())).toList();
				break;
			}
			case 8: {
				sortedProductRecords = products.stream()
						.sorted((e1, e2) -> Double.compare(e1.getStar_rating(), e2.getStar_rating())).toList();
				break;
			}

			default: {
				sortedProductRecords = products.stream()
						.sorted((e1, e2) -> Integer.compare(e1.getProduct_id(), e2.getProduct_id())).toList();
			}
			}
		} catch (Exception e) {
			throw e;
		}
		return sortedProductRecords;
	}

	@Override
	public Product fetchRecord(Integer id) throws ClassNotFoundException, SQLException, Exception {
		Product product = null;
		try {
			if (id > 0) {
				product = _repository.getRecord(id);
			} else {
				throw new IllegalArgumentException("EMPLOYEE ID SHOULD BE GREATER THAN ZERO");
			}
		} catch (IllegalArgumentException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return product;
	}

	@Override
	public Integer insertRecord(Product product) throws ClassNotFoundException, SQLException, Exception {
		Integer insertStatus = null;
		try {			
			insertStatus = _repository.addRecord(product);
		} catch (Exception e) {
			throw e;
		}
		return insertStatus;
	}

	@Override
	public Integer modifyRecord(Product product, Integer id) throws ClassNotFoundException, SQLException, Exception {
		Integer updateStatus = null;
		try {			
			updateStatus = _repository.updateRecord(product, id);
		} catch (Exception e) {
			throw e;
		}
		return updateStatus;
	}

	@Override
	public Integer removeRecord(Integer id) throws ClassNotFoundException, SQLException, Exception {
		Integer result = null;
		try {
			if (id > 0) {
				result = _repository.deleteRecord(id);
			} else {
				throw new IllegalArgumentException("EMPLOYEE ID SHOULD BE GREATER THAN ZERO");
			}

			} catch (IllegalArgumentException e) {
				throw e;
			} catch (Exception e) {
				throw e;
			}
		return result;
	}

}
