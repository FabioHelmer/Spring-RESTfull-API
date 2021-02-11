package com.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.domain.User;
import com.demo.repository.UserRepository;
import com.demo.services.util.PasswordUtil;

@Service
public class UserService implements GenericService<User, String> {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(User entity) {
		User createdUser = userRepository.save(entity);
		String hash = PasswordUtil.getSecureHash(createdUser.getPassword());
		createdUser.setPassword(hash);
		return createdUser;
	}

	@Override
	public User update(User entity) {
		User updatedUser = userRepository.save(entity);
		String hash = PasswordUtil.getSecureHash(updatedUser.getPassword());
		updatedUser.setPassword(hash);
		return updatedUser;
	}

	@Override
	public User getById(String id) {
		Optional<User> result = userRepository.findById(id);
		return result.get();
	}

	@Override
	public List<User> listAll() {
		List<User> results = userRepository.findAll();
		return results;
	}

	@Override
	public void delete(User entity) {
		userRepository.delete(entity);

	}

	@Override
	public void deleteById(String id) {
		User entity = getById(id);
		delete(entity);
	}

	public User login(String email, String password) {
		password = PasswordUtil.getSecureHash(password);
		Optional<User> result = userRepository.login(email, password);
		return result.get();
	}

}
