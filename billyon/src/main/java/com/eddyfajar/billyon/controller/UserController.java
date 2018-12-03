package com.eddyfajar.billyon.controller;

import java.util.Date;
import java.util.List;
import javax.validation.Valid;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.eddyfajar.billyon.constant.BillyonConstant;
import com.eddyfajar.billyon.exception.ResourceNotFoundException;
import com.eddyfajar.billyon.generator.ValueGenerator;
import com.eddyfajar.billyon.model.LoginResponse;
import com.eddyfajar.billyon.model.Menu;
import com.eddyfajar.billyon.model.ResponseModel;
import com.eddyfajar.billyon.model.Store;
import com.eddyfajar.billyon.model.User;
import com.eddyfajar.billyon.repository.MenuRepository;
import com.eddyfajar.billyon.repository.StoreRepository;
import com.eddyfajar.billyon.repository.UserRepository;

/**
 * @author ig.eddy.p.putra
 * 
 * Nov 24, 2018 2:03:55 PM
 * @eddypastika
 */
@RestController
@RequestMapping("/user")
public class UserController extends ResponseModelController<User>{
	
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
	
	@PostMapping("/add")
	public ResponseModel<User> registerUser(@Valid @RequestBody User user) {
		
		User u = new User();
		ValueGenerator generator = new ValueGenerator();
		user.setId(generator.GenerateId());
		u = userRepository.save(user);
		
		setResponse(u, BillyonConstant.ADD_USER_ERROR_TRUE, BillyonConstant.ADD_USER_ERROR_FALSE, false, null);
		
		return result;
	}
	
	@PutMapping("/edit/{user_id}")
	public ResponseModel<User> updateUser(@PathVariable Long user_id,
							@Valid @RequestBody User userRequest) {
		
		//Get User Data by Id
		User userResult = userRepository.findById(user_id)
				.map(user -> {
					user.setFirst_name(userRequest.getFirst_name());
					user.setLast_name(userRequest.getLast_name());
					user.setEmail(userRequest.getEmail());
					user.setPhone(userRequest.getPhone());
					user.setAddress(userRequest.getAddress());
					user.setRole_id(userRequest.getRole_id());
					user.setPassword(userRequest.getPassword());
					user.setIs_active(userRequest.getIs_active());
					
					//update to DB
					userRepository.save(user);
					
					return user;

				}).orElseThrow(() -> new ResourceNotFoundException("User not found with id "+user_id));
		
		setResponse(userResult, BillyonConstant.EDIT_USER_ERROR_TRUE, BillyonConstant.EDIT_USER_ERROR_FALSE, false, null);
		
		return result;
	}
	
	@PutMapping("/deactivation/{user_id}")
	public ResponseModel<User> deactivationUser(@PathVariable Long user_id) {
		
		//Get User Data by Id
		User userResult = userRepository.findById(user_id)
				.map(user -> {
					user.setIs_active(0);
					
					//update to DB
					userRepository.save(user);
					
					return user;
					
					
				}).orElseThrow(() -> new ResourceNotFoundException("User not found with id "+user_id));
		
		setResponse(userResult, BillyonConstant.DEACT_USER_ERROR_TRUE, BillyonConstant.DEACT_USER_ERROR_FALSE, false, null);
		
		return result;
	}
	
	@DeleteMapping("/delete/{user_id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long user_id){
		return userRepository.findById(user_id)
				.map(user -> {
					userRepository.delete(user);
					return ResponseEntity.status(HttpStatus.OK).body("User with id: " + user_id +" Successfully deleted!");
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
