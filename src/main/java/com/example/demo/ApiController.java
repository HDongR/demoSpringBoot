package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.UserProfileMapper;

@RestController
public class ApiController {
	
	private UserProfileMapper mapper;
	
	public ApiController(UserProfileMapper mapper) {
		this.mapper = mapper;
	}
	
	@GetMapping("/user/{id}")
	public UserProfile getUserProfile(@PathVariable("id") String id) {
		return mapper.getUserProfile(id);
	}
	
	@GetMapping("/user/all")
	public List<UserProfile> getUserProfileList() {
		return mapper.getUserProfileList();
	}
	
	@PutMapping("/user/putUser")
	public void putUserProfile(@ModelAttribute("userProfile")UserProfile up) {
		mapper.insertUserProfile(up.getId(), up.getName(), up.getPhoneNum(), up.getAddr());
	}
	
	@PostMapping("/user/{id}")
	public void postUserProfile(@ModelAttribute("userProfile")UserProfile up) {
		mapper.updateUserProfile(up.getName(), up.getId());
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUserProfile(@PathVariable("id") String id) {
		mapper.deleteUserProfile(id);
	}
}
