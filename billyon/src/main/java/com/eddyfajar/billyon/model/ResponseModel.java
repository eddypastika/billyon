package com.eddyfajar.billyon.model;

import java.util.List;

/**
 * @author ig.eddy.p.putra
 * 
 * Nov 24, 2018 2:04:34 PM
 * @param <T>
 * @eddypastika
 */
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
	

	static public class ResponseModelList<T> {
		
		private boolean error;
		private String message;
		private List<T> data;	
		
		public ResponseModelList() {
		}
		
		public ResponseModelList(boolean error, String message, List<T> data) {
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
		public List<T> getData() {
			return data;
		}
		public void setData(List<T> data) {
			this.data = data;
		}
			
	}
}
