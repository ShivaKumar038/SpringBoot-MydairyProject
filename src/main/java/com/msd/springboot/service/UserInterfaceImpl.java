package com.msd.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msd.springboot.entities.User;
import com.msd.springboot.repositories.UserRepository;

@Service
public class UserInterfaceImpl implements userInterface {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(User user) {
		userRepository.delete(user);
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public List<User> findall() {
		return userRepository.findAll() ;
	}

	@Override
	public User findUserByUsername(String username) {
		
		return userRepository.findUserByUserId(username);
	}

}
