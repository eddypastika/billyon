package com.eddyfajar.billyon.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import com.eddyfajar.billyon.model.CategoryResponse;
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
	public ResponseModelList<CategoryResponse> addCategory (@Valid @RequestBody List<Category> categoryRequest) {

		List<CategoryResponse> listCategory = new ArrayList<>();

		for (Category c : categoryRequest) {
			CategoryResponse categoryResponse = new CategoryResponse();

			ValueGenerator generator = new ValueGenerator();
			c.setId(generator.GenerateId());

			Category cat = new Category();

			//VALIDATION if there any NULL field
			if (c.getCategory_name() == null || c.getImage_path() == null || c.getStore_id() == null){
				c.setCategory_name(c.getCategory_name() == null ? "0" : c.getCategory_name());
				c.setImage_path(c.getImage_path() == null ? "0" : c.getImage_path());
				c.setStore_id(c.getStore_id() == null ? 0L : c.getStore_id());

				cat = null;
			} else {
				cat = categoryRepository.save(c);
			}

			// CREATE custom response
			categoryResponse.setCategory_name(c.getCategory_name());
			categoryResponse.setImage_path(c.getImage_path());
			categoryResponse.setStore_id(c.getStore_id());
			categoryResponse.setId(c.getId());


			if (cat == null){
				categoryResponse.setIs_error(true);
				categoryResponse.setCreated_dt(new Date());
				categoryResponse.setUpdated_dt(new Date());
			} else {
				categoryResponse.setIs_error(false);
				categoryResponse.setCreated_dt(cat.getCreated_dt());
				categoryResponse.setUpdated_dt(cat.getUpdated_dt());
			}

			listCategory.add(categoryResponse);
		}

		ResponseModelController<CategoryResponse> response = new ResponseModelController<>();
		response.setResponse(null, BillyonConstant.ADD_CATEGORY_ERROR_TRUE, BillyonConstant.ADD_CATEGORY_ERROR_FALSE, true, listCategory);
		
		return response.resultList;
	}

}
