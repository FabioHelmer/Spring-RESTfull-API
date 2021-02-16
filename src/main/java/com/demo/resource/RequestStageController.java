package com.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.domain.RequestStage;
import com.demo.services.RequestStageService;

@RestController
@RequestMapping("stages")
public class RequestStageController {

	@Autowired
	private RequestStageService service;

	@PostMapping
	public ResponseEntity<RequestStage> save(@RequestBody RequestStage stage) {
		RequestStage stageCreated = service.save(stage);
		return ResponseEntity.status(HttpStatus.CREATED).body(stageCreated);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RequestStage> getById(@PathVariable(name = "id") String id) {
		RequestStage stage = service.getById(id);
		return ResponseEntity.ok(stage);
	}

	@GetMapping
	public ResponseEntity<List<RequestStage>> listAll() {
		List<RequestStage> stages = service.listAll();
		return ResponseEntity.ok(stages);
	}

}
