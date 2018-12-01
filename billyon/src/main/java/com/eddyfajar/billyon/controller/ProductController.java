package com.eddyfajar.billyon.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eddyfajar.billyon.constant.BillyonConstant;
import com.eddyfajar.billyon.generator.ValueGenerator;
import com.eddyfajar.billyon.model.Category;
import com.eddyfajar.billyon.model.Product;
import com.eddyfajar.billyon.model.ResponseModel.ResponseModelList;
import com.eddyfajar.billyon.repository.ProductRepository;

/**
 * @author ig.eddy.p.putra
 * 
 * Dec 1, 2018 7:24:22 PM
 * @eddypastika
 */

@RestController
@RequestMapping("/product")
public class ProductController extends ResponseModelController<Product> {
	
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping("/add")
	public ResponseModelList<Product> addProduct (@Valid @RequestBody List<Product> productRequest) {
		
		List<Product> listProduct = new ArrayList<>();

		for (Product p : productRequest) {
			
			ValueGenerator generator = new ValueGenerator();
			p.setId(generator.GenerateId());
			
			listProduct.add(productRepository.save(p));
		}
		setResponse(null, BillyonConstant.ADD_PRODUCT_ERROR_TRUE, BillyonConstant.ADD_PRODUCT_ERROR_FALSE, true, listProduct);
		
		return resultList;
	}

}
