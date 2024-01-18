package com.api.user.web.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.user.web.model.User;
import com.api.user.web.service.UserServiceImpl;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserServiceImpl serviceImpl;
	
	@PostMapping("/addNewUser")   //url: http://localhost:8081/api/user/addNewUser
	public User addNewUser(@RequestBody User usr) {
		return serviceImpl.addNewUser(usr);
	}
	
//	@PutMapping("/updateUserById/{userId}")  //url: http://localhost:8081/api/user/updateUserById/{userId} 
//	public User updateUserById(@PathVariable("userId") int userId) {
//		return serviceImpl.updateUser(userId, null, null, null)
//	}
	
//	@PutMapping("/updateUserById/{userId}")
//	public ResponseEntity<User> updateUser(@PathVariable int userId, @RequestBody UpdateUserRequest updateUserRequest) {
//			// Assume UpdateUserRequest is a DTO containing the updated user information
//			
//			User updatedUser = serviceImpl.updateUser(userId,
//			updateUserRequest.getUserAddress(),
//			updateUserRequest.getUserEmail(),
//			updateUserRequest.getUserName());
//			
//			if (updatedUser != null) {
//			return ResponseEntity.ok(updatedUser);
//			} else {
//			return ResponseEntity.notFound().build();
//			}
//			}

	
	@PutMapping("/updateUserById/{userId}")  //url: http://localhost:8081/api/user/updateUserById/{userId}
	public ResponseEntity<User> updateUserById(@PathVariable int userId) {
		  User updatedUser = serviceImpl.updateUserById(userId);
		       if (updatedUser != null) {
		          return ResponseEntity.ok(updatedUser);
		      } else {
		          return ResponseEntity.notFound().build();
		      }
		 }
	
	
	@GetMapping("/getUserById/{userId}")  //url: http://localhost:8081/api/user/getUserById/{userId}
	public Optional<User> getUserById(@PathVariable("userId") int userId) {
		return  serviceImpl.getUserById(userId);
	}
	
	@GetMapping("/getAllUsers")  //url: http://localhost:8081/api/user/getAllUsers
	public List<User> getAllUsers(){
		return serviceImpl.getAllUsers();
	}
	
	@DeleteMapping("/deleteUserById/{userId}")  //url: http://localhost:8081/api/user/deleteUserById/{userId}
	public void deleteUserById(@PathVariable("userId") int userId) {
		serviceImpl.deleteUserById(userId);
	}
}
