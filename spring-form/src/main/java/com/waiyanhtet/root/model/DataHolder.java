package com.waiyanhtet.root.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import com.waiyanhtet.dto.UserInput;

@Service
@ApplicationScope
public class DataHolder {

	private List<UserInput> repository;
	
	public DataHolder() {
		repository = new ArrayList<>();
	}
	
	public void add(UserInput data) {
		repository.add(data);
	}
	
	public List<UserInput> getAllData() {
		return repository;
	}
	
}
