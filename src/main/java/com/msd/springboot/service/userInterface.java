package com.msd.springboot.service;

import java.util.List;

import com.msd.springboot.entities.User;

public interface userInterface {

	public User saveUser(User user);
	public User updateUser(User user);
	public void deleteUser(User user);
	public User findById(Long id);
	public List<User> findall();
	public User findUserByUsername(String username);
}
