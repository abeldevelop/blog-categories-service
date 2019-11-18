package com.abeldevelop.blog.category.repository.impl;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import com.abeldevelop.blog.category.model.CategoryEntity;
import com.abeldevelop.blog.category.repository.CategoryRepository;
import com.abeldevelop.blog.category.repository.springdata.CategorySpringDataRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

	private final CategorySpringDataRepository categorySpringDataRepository;
	
	@Override
	public CategoryEntity executeSave(CategoryEntity categoryEntity) {
		return categorySpringDataRepository.save(categoryEntity);
	}

	@Override
	public Optional<CategoryEntity> executeFindById(String id) {
		return categorySpringDataRepository.findById(id);
	}
	
	@Override
	public void executeDeleteById(String code) {
		categorySpringDataRepository.deleteById(code);
	}

    public Page<CategoryEntity> executeFindAll(Specification<CategoryEntity> spec, Pageable pageable) {
        return categorySpringDataRepository.findAll(spec, pageable);
    }
	
}
