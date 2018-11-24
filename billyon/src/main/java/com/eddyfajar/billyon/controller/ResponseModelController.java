package com.eddyfajar.billyon.controller;

import java.util.List;

import com.eddyfajar.billyon.model.ResponseModel;
import com.eddyfajar.billyon.model.ResponseModel.ResponseModelList;
import com.eddyfajar.billyon.model.Store;
import com.eddyfajar.billyon.model.User;

/**
 * @author ig.eddy.p.putra
 * 
 * function for extend class
 * 
 * Nov 24, 2018 3:03:19 PM
 * @param <T>
 * @eddypastika
 */
public class ResponseModelController<T> {
	
	// for response template
	String message = "";
	boolean error = false;
	ResponseModel<T> result = new ResponseModel<>();
	ResponseModelList<T> resultList = new ResponseModelList<>();
	
	public void setResponse(T input, String errorMsg, String successMsg, boolean isList, List<T> inputList) {

		// Check if the result is list or class 
		if (isList == false) {
			
			if (input == null) {
				error = true;
				message = errorMsg;
				result.setData(null);
			} else {
				message = successMsg;
				result.setData(input);
				
			}
			result.setError(error);
			result.setMessage(message);
			
		} else {
			
			if (inputList == null) {
				error = true;
				message = errorMsg;
				resultList.setData(null);
			} else {
				message = successMsg;
				resultList.setData(inputList);
				
			}
			
			resultList.setError(error);
			resultList.setMessage(message);
		}

			
	}

}
