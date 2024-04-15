package com.msd.springboot.service;

import java.util.List;

import com.msd.springboot.entities.Entry;

public interface EntryInterface {
	
	public Entry saveEntry(Entry entry);
	public Entry updateEntry(Entry entry);
	public void deleteEntry(Entry entry);
	public Entry findById(Long id);
	public List<Entry> findAll();
	public List<Entry> findUserById(long id);

}
