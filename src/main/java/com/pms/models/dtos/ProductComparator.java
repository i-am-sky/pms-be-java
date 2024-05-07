package com.pms.models.dtos;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {

	private int choice;

	public ProductComparator() {
	};

	public ProductComparator(int choice) {
		this.choice = choice;
	}

	@Override
	public int compare(Product product1, Product product2) {
		
		int sortOrder = 0;
		
		if(product1 == product2) {
			return sortOrder;
		}
		
		switch (choice) {
		case 1: {
			sortOrder = Integer.compare(product1.getProduct_id(), product2.getProduct_id());
			break;
		}
		case 2: {
			sortOrder = product1.getProduct_name().compareTo(product2.getProduct_name());
			break;
		}
		case 3: {
			sortOrder = Double.compare(product1.getPrice(), product2.getPrice());
			break;
		}
		case 4: {
			sortOrder = product1.getRelease_date().compareTo(product2.getRelease_date());
			break;
		}
		case 5: {
			sortOrder = Double.compare(product1.getStar_rating(), product2.getStar_rating());
			break;
		}
		case 6: {
			sortOrder = product1.getProduct_code().compareTo(product2.getProduct_code());
			break;
		}
		default: {
			sortOrder = Integer.compare(product1.getProduct_id(), product2.getProduct_id());
		}
		}
		
		return sortOrder;
	}

}
