package com.demo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.domain.Request;
import com.demo.domain.enums.RequestState;
import com.demo.repository.RequestRepository;

@Service
public class RequestService implements GenericService<Request, String> {

	@Autowired
	private RequestRepository requestRepository;

	@Override
	public Request save(Request entity) {
		Request createdRequest = requestRepository.save(entity);
		createdRequest.setState(RequestState.OPEN);
		createdRequest.setCreationDate(new Date());
		return createdRequest;
	}

	@Override
	public Request update(Request entity) {
		Request updatedRequest = requestRepository.save(entity);
		return updatedRequest;
	}

	@Override
	public Request getById(String id) {
		Optional<Request> result = requestRepository.findById(id);
		return result.get();
	}

	@Override
	public List<Request> listAll() {
		List<Request> results = requestRepository.findAll();
		return results;
	}

	public List<Request> listAllByOwnerId(String id) {
		List<Request> results = requestRepository.findAllByOwnerId(id);
		return results;
	}

	@Override
	public void delete(Request entity) {
		requestRepository.delete(entity);
	}

	@Override
	public void deleteById(String id) {
		Request entity = getById(id);
		delete(entity);
	}

}
