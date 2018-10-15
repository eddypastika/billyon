package com.eddyfajar.billyon.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eddyfajar.billyon.exception.ResourceNotFoundException;
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

}