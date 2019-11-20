package com.abeldevelop.blog.category.service.service.v1.impl;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.abeldevelop.blog.category.model.CategoryEntity;
import com.abeldevelop.blog.category.repository.CategoryRepository;
import com.abeldevelop.blog.category.service.component.ErrorMessageProperties;
import com.abeldevelop.blog.category.service.domain.Category;
import com.abeldevelop.blog.category.service.exception.category.CategoryExistException;
import com.abeldevelop.blog.category.service.mapper.CategoryMapper;
import com.abeldevelop.blog.category.service.service.v1.CreateCategoryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CreateCategoryServiceImpl implements CreateCategoryService {

	private final CategoryRepository categoryRepository;
	private final CategoryMapper categoryMapper;
	
	@Override
	public Category executeCreate(Category category) {
		checkIfCategoryExist(category);
		return categoryMapper.mapEntityToDomain(categoryRepository.executeSave(categoryMapper.mapDomainToEntity(category)));
	}
	
	private void checkIfCategoryExist(Category category) {
		Optional<CategoryEntity> categoryEntityOptional = categoryRepository.executeFindById(category.getCode());
		if(categoryEntityOptional.isPresent()) {
			throw new CategoryExistException(ErrorMessageProperties.CATEGORY_CODE_EXIST, Arrays.asList(category.getName()));
		}
	}
}
