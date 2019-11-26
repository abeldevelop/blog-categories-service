package com.abeldevelop.blog.category.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.abeldevelop.blog.category.model.CategoryEntity;

public interface CategoryRepository {

	public CategoryEntity executeSave(CategoryEntity categoryEntity);
	
	public Optional<CategoryEntity> executeFindById(String id);
	
	public Optional<CategoryEntity> executeFindOne(Specification<CategoryEntity> spec);
	
	public void executeDeleteById(String code);

	public Page<CategoryEntity> executeFindAll(Pageable pageable);
	
	public Page<CategoryEntity> executeFindAll(Specification<CategoryEntity> spec, Pageable pageable);
	
}
