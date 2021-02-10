package com.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	@Query("SELECT e FROM User AS e WHERE email = ?1 AND password = ?2")
	public Optional<User> login(String email, String password);


}
