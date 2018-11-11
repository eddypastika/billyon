package com.eddyfajar.billyon.controller;

import java.util.List;

import javax.validation.Valid;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.eddyfajar.billyon.exception.ResourceNotFoundException;
import com.eddyfajar.billyon.model.ResponseModel;
import com.eddyfajar.billyon.model.User;
import com.eddyfajar.billyon.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	public Page<User> getAllUsers(Pageable pageable){
		return userRepository.findAll(pageable);
	}
	
	@PostMapping("/register_user")
	public User registerUser(@Valid @RequestBody User user) {
		//User userRegister = new User();
		//BCryptPasswordEncoder passwordEncoder =  new BCryptPasswordEncoder();
		
//		userRegister.setUser_name(user.getUser_name());
//		userRegister.setUser_address(user.getUser_address());
//		userRegister.setUser_email(user.getUser_email());
//		userRegister.setUser_phone(user.getUser_phone());
//		userRegister.setCreated_dt(user.getCreated_dt());
//		userRegister.setUpdated_dt(user.getUpdated_dt());
//		userRegister.setUser_role(user.getUser_role());
//		userRegister.setUser_password(user.getUser_password());
		//user.setUser_password(user.getUser_password());
		
		return userRepository.save(user);
	}
	
	@PutMapping("/edit_user/{user_id}")
	public User updateUser(@PathVariable Long user_id,
							@Valid @RequestBody User userRequest) {
		return userRepository.findById(user_id)
				.map(user -> {
					user.setUser_name(userRequest.getUser_name());
					user.setUser_email(userRequest.getUser_email());
					user.setUser_phone(userRequest.getUser_phone());
					user.setUser_address(userRequest.getUser_address());
					user.setUser_role(userRequest.getUser_role());
					user.setUser_password(userRequest.getUser_password());
					return userRepository.save(user);
				}).orElseThrow(() -> new ResourceNotFoundException("User not found with id "+user_id));
	}
	
	@DeleteMapping("/delete_user/{user_id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long user_id){
		return userRepository.findById(user_id)
				.map(user -> {
					userRepository.delete(user);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new ResourceNotFoundException("User not found with id "+user_id));
	}
	
	@PostMapping("/login")
	public ResponseModel<User> loginUser(@RequestBody User user){
		ResponseModel<User> result =  new ResponseModel<>();
		
		//Check username exist or not
		User data = userRepository.loginUser(user.getUser_name(), user.getUser_password());
		
		String message = "";
		boolean error = false; 
		if (data == null) {
			error = true;
			message = "login failed.";
		} else {
			error = false;
			message = "login successfully.";
		}
		//Result json
		result.setError(error);
		result.setMessage(message);
		result.setData(data);
		return result;
	}
	

}
