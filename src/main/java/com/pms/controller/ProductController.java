package com.pms.controller;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pms.models.dtos.Product;
import com.pms.models.services.ServiceContract;

@RestController
public class ProductController {
	
	@Autowired
	private ServiceContract<Product, Integer> _service;
	
	@GetMapping(path = "/product/all/sort/{sortChoice}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<List<Product>> getProducts(@PathVariable("sortChoice") int sortChoice)
			throws ClassNotFoundException, SQLException, Exception {
		List<Product> productRecords = null;
		try {
			if (sortChoice > 0 && sortChoice < 9) {
				productRecords = _service.fetchRecords(sortChoice);
			} else {
				throw new IllegalArgumentException("CHOICE MUST BE BETWEEN 1 AND 8");
			}
			return ResponseEntity.ok(productRecords);

		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}

	@CrossOrigin(origins = "*")
	@GetMapping(path = "/product/view/{pid}")
	public ResponseEntity<Product> getProductById(@PathVariable("pid") int pid)
			throws IllegalArgumentException, Exception {

		Product product = null;
		try {
			if (pid > 0) {
				product = _service.fetchRecord(pid);
			} else {
				throw new IllegalArgumentException("PRODUCT ID SHOULD BE GREATER THAN ZERO");
			}
			return ResponseEntity.ok(product);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@PostMapping(path = "product/add")
	@CrossOrigin(origins = "*")
	public ResponseEntity<Integer> addProduct(@RequestBody Product product) throws  Exception {

		Integer result = null;
		try {
			result = _service.insertRecord(product);
			if (result > 0) {
				ResponseEntity.of(Optional.of(result));
				return ResponseEntity.status(HttpStatus.CREATED).build();
			} else {
				ResponseEntity.of(Optional.empty());
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		} catch (SQLIntegrityConstraintViolationException e) {
			return ResponseEntity.badRequest().build();
		}
		catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@PutMapping(path = "product/update/{pid}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<Integer> updateProduct(@RequestBody Product product, @PathVariable("pid") int pid) throws Exception {

		Integer updateStatus = null;
		try {
			updateStatus = _service.modifyRecord(product, pid);
			if (updateStatus > 0) {
				ResponseEntity.of(Optional.of(updateStatus));
				return ResponseEntity.status(HttpStatus.CREATED).build();
			} else {
				ResponseEntity.of(Optional.empty());
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@DeleteMapping(path = "product/delete/{pid}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<Integer> deleteEmployee(@PathVariable("pid") int pid) throws Exception {

		Integer deleteStatus = null;
		try {
			deleteStatus = _service.removeRecord(pid);
			if (deleteStatus > 0) {
				ResponseEntity.of(Optional.of(deleteStatus));
				return ResponseEntity.status(HttpStatus.CREATED).build();
			} else {
				ResponseEntity.of(Optional.empty());
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}
	
	
	
	
	
}
