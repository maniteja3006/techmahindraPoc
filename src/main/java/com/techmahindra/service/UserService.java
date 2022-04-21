package com.techmahindra.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.techmahindra.model.User;
import com.techmahindra.repository.UserRepository;

public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	
	public Integer saveUser(User user) {
		return userRepo.save(user).getId();
	}
	
	@Transactional(readOnly = true) 
 	public User findByUsername(String username) { 
 	 	Optional<User> user=userRepo.findByUsername(username); 
 	 	if(user.isPresent())  
	 	 	return user.get();  
 	 	return null;
 	} 
	
	
	@Transactional(readOnly = true) 
 	public UserDetails loadUserByUsername(String username)   throws UsernameNotFoundException  
 	{ 
 	 	User user=findByUsername(username);   	 
 	 	if(user==null)  
 	 	 	throw new UsernameNotFoundException( 
 	 	 	 	 	new StringBuffer()  	 	 	 	 	
 	 	 	 	 	.append("User name ") 
 	 	 	 	 	.append(username) 
 	 	 	 	 	.append(" not found!") 
 	 	 	 	 	.toString() 
 	 	 	 	 	); 
 
 	 	List<GrantedAuthority> authorities= 
 	 	 	 	user.getRoles() 
 	 	 	 	.stream() 
 	 	 	 	.map( 
 	 	 	 	 	 	role->new SimpleGrantedAuthority(role) 
 	 	 	 	 	 	) 
 	 	 	 	.collect(Collectors.toList()); 
 
 	 	return new org.springframework.security.core.userdetails.User( 
 	 	 	 	username,  
 	 	 	 	user.getPassword(),  
 	 	 	 	authorities); 
 	} 

 


}
