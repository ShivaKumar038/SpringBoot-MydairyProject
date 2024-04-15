package com.msd.springboot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.msd.springboot.entities.Entry;

public interface EntryRepository extends JpaRepository<Entry, Long> {

	@Query(value = "SELECT * FROM entries WHERE userid=:id",nativeQuery = true)
	public List<Entry> findUserById(long id);
}
