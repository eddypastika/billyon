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
import com.eddyfajar.billyon.model.LoginResponse;
import com.eddyfajar.billyon.model.Menu;
import com.eddyfajar.billyon.model.ResponseModel;
import com.eddyfajar.billyon.model.Store;
import com.eddyfajar.billyon.model.User;
import com.eddyfajar.billyon.repository.MenuRepository;
import com.eddyfajar.billyon.repository.StoreRepository;
import com.eddyfajar.billyon.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
	private MenuRepository menuRepository;
	
	@GetMapping("/users")
	public Page<User> getAllUsers(Pageable pageable){
		return userRepository.findAll(pageable);
	}
	
	@PostMapping("/register_user")
	public User registerUser(@Valid @RequestBody User user) {
		
		return userRepository.save(user);
	}
	
//	@PutMapping("/edit_user/{user_id}")
//	public User updateUser(@PathVariable Long user_id,
//							@Valid @RequestBody User userRequest) {
//		return userRepository.findById(user_id)
//				.map(user -> {
//					user.setUser_name(userRequest.getUser_name());
//					user.setUser_email(userRequest.getUser_email());
//					user.setUser_phone(userRequest.getUser_phone());
//					user.setUser_address(userRequest.getUser_address());
//					user.setUser_role(userRequest.getUser_role());
//					user.setUser_password(userRequest.getUser_password());
//					return userRepository.save(user);
//				}).orElseThrow(() -> new ResourceNotFoundException("User not found with id "+user_id));
//	}
	
	@DeleteMapping("/delete_user/{user_id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long user_id){
		return userRepository.findById(user_id)
				.map(user -> {
					userRepository.delete(user);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new ResourceNotFoundException("User not found with id "+user_id));
	}
	
	@PostMapping("/login")
	public ResponseModel<LoginResponse> loginUser(@RequestBody User user){
		ResponseModel<LoginResponse> result =  new ResponseModel<>();
		LoginResponse loginResponse =  new LoginResponse();
		
		//Check username exist or not
		User userLogedin = userRepository.loginUser(user.getEmail(), user.getPassword());
		
		String message = "";
		boolean error = false; 
		if (userLogedin == null) {
			error = true;
			message = "Login failed. Wrong email or password.";
		} else {
			//IF is_active = 0
			if (userLogedin.getIs_active() == 0) {
				
				error = true;
				message = "Sorry, this user is inactive.";
				loginResponse = null;
				
			} else {
				
				error = false;
				message = "login successfully.";
				
				//Hide Password:
				userLogedin.setPassword(null);
				//Get stores
				List<Store> userStores = storeRepository.userStores(userLogedin.getId());
				
				//Get menus
				List<Menu> userMenus = menuRepository.listUserMenus(userLogedin.getRole_id());
				
				//Set Login Response
				loginResponse.setUsers(userLogedin);
				loginResponse.setStores(userStores);
				loginResponse.setMenus(userMenus);
			}
		}
		//Result json
		result.setError(error);
		result.setMessage(message);
		result.setData(loginResponse);
		return result;
	}
	

}
