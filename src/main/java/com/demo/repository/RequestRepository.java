package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.domain.Request;
import com.demo.domain.enums.RequestState;

@Repository
public interface RequestRepository extends JpaRepository<Request, String> {

	public List<Request> findAllByOwnerId(String id);

	@Query("UPDATE Request SET state = ?2 WHERE id = ?1")
	public Request updateStatus(String id, RequestState state);

}
