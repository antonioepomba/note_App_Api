package com.user.note_App_Api.resources;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.note_App_Api.model.Note;
import com.user.note_App_Api.model.Users;
import com.user.note_App_Api.repository.UserRepository;


@RestController
@RequestMapping(value = "/api")
public class UserResource {
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/user")
	public Users saveUser(@RequestBody Users users) {
		 return userRepository.save(users);
	 }
	 
	
	 @GetMapping("/users")
	 @ResponseBody
	 public  List<Users> getAllUsers(){
		 return userRepository.findAll();
	 }
	 
	 @GetMapping("/user/{id}")
	 @ResponseBody
	 public Optional<Users> getUserById(@PathVariable("id") Long id){
		 return userRepository.findById(id);
	 }
	 
	 @DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		 userRepository.deleteById(id);
	 }
	 
	 @PutMapping("/user")
	public void updateUser(@RequestBody Users users) {
		 userRepository.save(users);
	 }
	  
}
