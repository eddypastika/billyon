package com.eddyfajar.billyon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eddyfajar.billyon.model.ResponseModel;
import com.eddyfajar.billyon.model.ResponseModel.ResponseModelList;
import com.eddyfajar.billyon.model.Store;
import com.eddyfajar.billyon.model.User;
import com.eddyfajar.billyon.repository.StoreRepository;

@RestController
public class StoreController {
	
	@Autowired
	private StoreRepository storeRepository;

	// Get all stores by user_id
	@GetMapping("/stores/{user_id}")
	public ResponseModelList<Store> getStoresByUserId(@PathVariable Long user_id){
		
		ResponseModelList<Store> result =  new ResponseModelList<>();
		String message = "";
		boolean error = false;
		
		List<Store> stores = storeRepository.userStores(user_id);
		
		if (stores == null){
			error = true;
			message = "Stores not found.";
			result.setData(null);
		} else {
			error = false;
			message = "Stores found.";
			result.setData(stores);
		}
		
		result.setError(error);
		result.setMessage(message);
		
		return result;
	}
	
	
}
