package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.domain.User;

@Repository
public interface RequestStageRepository extends JpaRepository<User, String> {

}
