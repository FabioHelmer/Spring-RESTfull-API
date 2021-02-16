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
import org.springframework.web.bind.annotation.RestController;

import com.demo.domain.Request;
import com.demo.domain.User;
import com.demo.dto.UserLoginDto;
import com.demo.services.RequestService;
import com.demo.services.UserService;

@RestController
@RequestMapping(value = "users")
public class UserController {

	@Autowired
	private UserService service;

	@Autowired
	private RequestService requestService;

	@PostMapping
	public ResponseEntity<User> save(@RequestBody User user) {
		User userCreated = service.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> update(@RequestBody User user, @PathVariable(name = "id") String id) {
		user.setId(id);
		User userUpdated = service.update(user);
		return ResponseEntity.ok(userUpdated);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable(name = "id") String id) {
		User user = service.getById(id);
		return ResponseEntity.ok(user);
	}

	@GetMapping
	public ResponseEntity<List<User>> listAll() {
		List<User> users = service.listAll();
		return ResponseEntity.ok(users);
	}

	@GetMapping("/{id}/requests")
	public ResponseEntity<List<Request>> listAllRequestsById(@PathVariable(name = "id") String id) {
		List<Request> requests = requestService.listAllByOwnerId(id);
		return ResponseEntity.ok(requests);
	}

	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody UserLoginDto user) {
		User loggedUser = service.login(user.getEmail(), user.getPassword());
		return ResponseEntity.ok(loggedUser);
	}

	@PostMapping("/{id}")
	public ResponseEntity<User> delete(@PathVariable(name = "id") String id) {
		User userDeleted = service.getById(id);
		service.deleteById(id);
		return ResponseEntity.ok(userDeleted);
	}

}
