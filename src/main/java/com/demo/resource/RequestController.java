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
import com.demo.services.RequestService;

@RestController
@RequestMapping("requests")
public class RequestController {

	@Autowired
	private RequestService service;

	@PostMapping
	public ResponseEntity<Request> save(@RequestBody Request request) {
		Request requestCreated = service.save(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(requestCreated);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Request> update(@RequestBody Request request, @PathVariable(name = "id") String id) {
		request.setId(id);
		Request requestUpdated = service.update(request);
		return ResponseEntity.ok(requestUpdated);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Request> getById(@PathVariable(name = "id") String id) {
		Request request = service.getById(id);
		return ResponseEntity.ok(request);
	}

	@GetMapping
	public ResponseEntity<List<Request>> listAll() {
		List<Request> requests = service.listAll();
		return ResponseEntity.ok(requests);
	}

	@PostMapping("/{id}")
	public ResponseEntity<Request> delete(@PathVariable(name = "id") String id) {
		Request requestDeleted = service.getById(id);
		service.deleteById(id);
		return ResponseEntity.ok(requestDeleted);
	}

}
