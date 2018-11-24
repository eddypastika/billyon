package com.eddyfajar.billyon.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eddyfajar.billyon.constant.BillyonConstant;
import com.eddyfajar.billyon.model.ResponseModel;
import com.eddyfajar.billyon.model.ResponseModel.ResponseModelList;
import com.eddyfajar.billyon.model.Store;
import com.eddyfajar.billyon.model.User;
import com.eddyfajar.billyon.repository.StoreRepository;

/**
 * @author ig.eddy.p.putra
 * 
 * Nov 24, 2018 2:04:25 PM
 * @eddypastika
 */
@RestController
public class StoreController extends ResponseModelController<Store> {
	
	@Autowired
	private StoreRepository storeRepository;

	// Get all stores by user_id
	@GetMapping("/stores/{user_id}")
	public ResponseModelList<Store> getStoresByUserId(@PathVariable Long user_id){
		
		List<Store> stores = storeRepository.userStores(user_id);
		setResponse(null, BillyonConstant.LIST_STORE_ERROR_TRUE, BillyonConstant.LIST_STORE_ERROR_FALSE, true, stores);
		
		return resultList;
	}
	
	@PostMapping("/add_store")
	public ResponseModel<Store> addStore(@Valid @RequestBody Store newStore) {
		
		Store savedStore = storeRepository.save(newStore);
		setResponse(savedStore, BillyonConstant.ADD_STORE_ERROR_TRUE, BillyonConstant.ADD_STORE_ERROR_FALSE, false, null);
		return result;
	}
	
	
}
