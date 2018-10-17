package com.eddyfajar.billyon.model;

public class ResponseModel<T> {
	
	private boolean error;
	private String message;
	private T data;
	
	
	public ResponseModel() {
	
	}


	public ResponseModel(boolean error, String message, T data) {
		this.error = error;
		this.message = message;
		this.data = data;
	}


	public boolean isError() {
		return error;
	}


	public void setError(boolean error) {
		this.error = error;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public T getData() {
		return data;
	}


	public void setData(T data) {
		this.data = data;
	}	

}
