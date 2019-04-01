package com.pro.forum.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pro.forum.model.User;
import com.pro.forum.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:4200") // Cette @CrossOrigin annotation active les demandes d'origine croisée uniquement pour cette méthode spécifique.
@RestController
@RequestMapping("/api")  // L' @RequestMappingannotation garantit que les demandes HTTP à /api mappées à la class UserController .
public class UserController {

	@Autowired
	UserRepository repository;

	@GetMapping("/user")
	public List<User> showAllUsers() {
		System.out.println("Get all users...");

		List<User> users = new ArrayList<>();
		repository.findAll().forEach(users::add);

		return users;
	}

	@PostMapping("/user")
	public User addUser(@RequestBody User user) {

		User _user = repository.save(new User(user.getUsername(), user.getUserEmail(), user.getPassword(), user.getPasswordConfirm()));
		return _user;
	}


	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") long id) {
		System.out.println("Delete user with ID = " + id + "...");

		repository.deleteById(id);

		return new ResponseEntity<>("user has been deleted!", HttpStatus.OK);
	}

/*	@GetMapping("customers/age/{age}")
	public List<User> findByAge(@PathVariable int age) {

		List<User> customers = repository.findByAge(age);
		return customers;
	}*/

	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
		System.out.println("Update user with ID = " + id + "...");

		Optional<User> customerData = Optional.ofNullable(repository.findById(id));

		if (customerData.isPresent()) {
			User _user = customerData.get();
			_user.setUsername(user.getUsername());
			_user.setUserEmail(user.getUserEmail());
			return new ResponseEntity<>(repository.save(_user), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


}