package com.msd.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.msd.springboot.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "select * from users where username=:username LIMIT 1",nativeQuery = true)
	public User findUserByUserId(String username);
}
