package com.techmahindra.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techmahindra.model.User;
import com.techmahindra.model.UserRequest;
import com.techmahindra.model.UserResponse;
import com.techmahindra.service.UserService;
import com.techmahindra.util.JwtUtil;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired 
 	private AuthenticationManager authenticationManager;  

	@Autowired 
 	private JwtUtil jwtUtil; 

	
	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody User user){
		Integer id=userService.saveUser(user);
		String body="User with "+id+"saved successfully";
		return ResponseEntity.ok(body);
	}

	@PostMapping("/login") 
	 public ResponseEntity<UserResponse> loginUser(@RequestBody UserRequest userRequest) 
	 	{ 
	 
	 	 	authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(userRequest.getUsername(),userRequest.getPassword())); 
	 
	 	 	String token=jwtUtil.generateToken(userRequest.getUsername()); 
	 
	 	 	return ResponseEntity.ok(new UserResponse(token,"GENERATED BY Mani")); 
	 	} 
	 	 
	
	 	@PostMapping("/welcome")  	
	 	public ResponseEntity<String> accessUserData(Principal p) {  	 
	 		return ResponseEntity.ok("Hello user:"+p.getName()); 
	 	} 

}
