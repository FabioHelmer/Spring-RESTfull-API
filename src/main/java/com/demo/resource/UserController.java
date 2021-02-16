package com.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.domain.User;
import com.demo.dto.UserLoginDto;
import com.demo.services.UserService;

@RestController
@RequestMapping(value = "users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<User> save(@RequestParam User user) {
		User userCreated = userService.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> update(@RequestParam User user, @PathVariable(name = "id") String id) {
		user.setId(id);
		User userUpdated = userService.update(user);
		return ResponseEntity.ok(userUpdated);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable(name = "id") String id) {
		User user = userService.getById(id);
		return ResponseEntity.ok(user);
	}

	@GetMapping
	public ResponseEntity<List<User>> listAll() {
		List<User> users = userService.listAll();
		return ResponseEntity.ok(users);
	}

	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody UserLoginDto user) {
		User loggedUser = userService.login(user.getEmail(), user.getPassword());
		return ResponseEntity.ok(loggedUser);
	}

}
