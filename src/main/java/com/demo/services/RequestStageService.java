package com.demo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.domain.RequestStage;
import com.demo.repository.RequestRepository;
import com.demo.repository.RequestStageRepository;

@Service
public class RequestStageService implements GenericService<RequestStage, String> {

	@Autowired
	private RequestStageRepository requestStageRepository;

	@Autowired
	private RequestRepository requestRepository;

	@Override
	public RequestStage save(RequestStage entity) {
		entity.setRealizationDate(new Date());
		RequestStage createdRequestStage = requestStageRepository.save(entity);

		try {
			requestRepository.updateStatus(entity.getRequest().getId(), entity.getState());
		} catch (Exception e) {
			System.out.println("erro ao atualizar o status do request");
			e.printStackTrace();
		}

		return createdRequestStage;
	}

	@Override
	@Deprecated
	public RequestStage update(RequestStage entity) {
		return null;
	}

	@Override
	public RequestStage getById(String id) {
		Optional<RequestStage> result = requestStageRepository.findById(id);
		return result.get();
	}

	@Override
	public List<RequestStage> listAll() {
		List<RequestStage> results = requestStageRepository.findAll();
		return results;
	}

	@Override
	@Deprecated
	public void delete(RequestStage entity) {
	}

	@Override
	@Deprecated
	public void deleteById(String id) {
	}

	public List<RequestStage> listAllByRequestId(String id) {
		return requestStageRepository.findAllByRequestId(id);
	}

}
