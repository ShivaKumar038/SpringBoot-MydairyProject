package com.msd.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msd.springboot.entities.Entry;
import com.msd.springboot.repositories.EntryRepository;

@Service
public class EntryInterfaceImpl implements EntryInterface {
	
	@Autowired
	private EntryRepository entryRepository;
	
	

	@Override
	public Entry saveEntry(Entry entry) {
		return entryRepository.save(entry);
	}

	@Override
	public Entry updateEntry(Entry entry) {
		return entryRepository.save(entry);
	}

	@Override
	public void deleteEntry(Entry entry) {
          entryRepository.delete(entry);		
	}

	@Override
	public Entry findById(Long id) {
		return entryRepository.findById(id).get();
	}

	@Override
	public List<Entry> findAll() {
		return entryRepository.findAll();
	}

	@Override
	public List<Entry> findUserById(long id) {
		
		return entryRepository.findUserById(id);
	}

}
