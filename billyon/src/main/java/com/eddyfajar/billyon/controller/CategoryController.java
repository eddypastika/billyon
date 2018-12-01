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
import com.eddyfajar.billyon.model.ResponseModel;
import com.eddyfajar.billyon.model.ResponseModel.ResponseModelList;
import com.eddyfajar.billyon.repository.CategoryRepository;

/**
 * @author ig.eddy.p.putra
 * 
 * Nov 24, 2018 8:59:14 PM
 * @eddypastika
 */

@RestController
@RequestMapping("/category")
public class CategoryController extends ResponseModelController<Category> {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@PostMapping("/add")
	public ResponseModelList<Category> addCategory (@Valid @RequestBody List<Category> categoryRequest) {
		
		List<Category> listCategory = new ArrayList<>();

		for (Category c : categoryRequest) {
			
			ValueGenerator generator = new ValueGenerator();
			c.setId(generator.GenerateId());
			
			listCategory.add(categoryRepository.save(c));
		}
		setResponse(null, BillyonConstant.ADD_CATEGORY_ERROR_TRUE, BillyonConstant.ADD_CATEGORY_ERROR_FALSE, true, listCategory);
		
		return resultList;
	}

}
