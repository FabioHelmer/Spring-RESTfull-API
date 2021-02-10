package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.domain.RequestStage;

@Repository
public interface RequestRepository extends JpaRepository<RequestStage, String> {


}
