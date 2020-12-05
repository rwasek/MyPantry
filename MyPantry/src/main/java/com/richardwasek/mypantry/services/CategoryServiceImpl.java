package com.richardwasek.mypantry.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.richardwasek.mypantry.entities.Category;
import com.richardwasek.mypantry.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository catRepo;

	@Override
	public List<Category> index() {
		return catRepo.findAll();
	}

}
