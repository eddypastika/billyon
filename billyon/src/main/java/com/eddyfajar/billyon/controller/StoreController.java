package com.eddyfajar.billyon.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eddyfajar.billyon.constant.BillyonConstant;
import com.eddyfajar.billyon.exception.ResourceNotFoundException;
import com.eddyfajar.billyon.generator.ValueGenerator;
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
@RequestMapping("/store")
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
	
	@PostMapping("/add")
	public ResponseModel<Store> addStore(@Valid @RequestBody Store newStore) {
		
		// GENERATE ID
		ValueGenerator generator = new ValueGenerator();
		newStore.setId(generator.GenerateId());
		
		Store savedStore = storeRepository.save(newStore);
		setResponse(savedStore, BillyonConstant.ADD_STORE_ERROR_TRUE, BillyonConstant.ADD_STORE_ERROR_FALSE, false, null);
		return result;
	}
	
	@PutMapping("/edit/{store_id}")
	public ResponseModel<Store> updateStore(@PathVariable Long store_id,
							@Valid @RequestBody Store storeRequest) {
		
		//Get Store Data by Id
		Store storeResult = storeRepository.findById(store_id)
				.map(store -> {
					store.setAddress(storeRequest.getAddress());
					store.setEmail(storeRequest.getEmail());
					store.setLatitude(storeRequest.getLatitude());
					store.setLongitude(storeRequest.getLongitude());
					store.setStore_name(storeRequest.getStore_name());
					store.setStore_phone(storeRequest.getStore_phone());
					store.setStore_type(storeRequest.getStore_type());
					store.setIs_active(storeRequest.getIs_active());
					
					//update to DB
					storeRepository.save(store);
					
					return store;
					
				}).orElseThrow(() -> new ResourceNotFoundException("User not found with id "+store_id));
		
		setResponse(storeResult, BillyonConstant.EDIT_STORE_ERROR_TRUE, BillyonConstant.EDIT_STORE_ERROR_FALSE, false, null);
		
		return result;
	}
	
	@PutMapping("/deactivation/{store_id}")
	public ResponseModel<Store> deactivationStore(@PathVariable Long store_id) {
		
		//Get Store Data by Id
		Store storeResult = storeRepository.findById(store_id)
				.map(store -> {
					store.setIs_active(0);
					
					//update to DB
					storeRepository.save(store);
					
					return store;
					
				}).orElseThrow(() -> new ResourceNotFoundException("User not found with id "+store_id));
		
		setResponse(storeResult, BillyonConstant.DEACT_STORE_ERROR_TRUE, BillyonConstant.DEACT_STORE_ERROR_FALSE, false, null);
		
		return result;
	}
	
	
}
