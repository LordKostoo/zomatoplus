package com.thinkxfactor.zomatoplus.controller;

import com.thinkxfactor.zomatoplus.models.User;
import com.thinkxfactor.zomatoplus.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController{
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		User persistedUser=userRepository.save(user);
		return persistedUser;
	}
	
	@GetMapping("/getAll")
	public List<User> getAll(){
		List<User> listofusers=userRepository.findAll();
		return listofusers;
	}
@PostMapping("/login")
public User userlogin(@RequestBody User user) {
	User persistedUser=userRepository.findByNameAndPassword(user.getName(),user.getPassword());
	return persistedUser;
}
	


}
