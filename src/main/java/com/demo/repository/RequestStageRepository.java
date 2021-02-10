package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.domain.RequestStage;

@Repository
public interface RequestStageRepository extends JpaRepository<RequestStage, String> {

	public List<RequestStage> findAllByRequestId(String idRequest);

}
