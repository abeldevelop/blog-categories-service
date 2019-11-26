package com.abeldevelop.blog.category.service.service.v1.impl;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abeldevelop.architecture.library.property.enums.States;
import com.abeldevelop.blog.category.model.CategoryEntity;
import com.abeldevelop.blog.category.repository.CategoryRepository;
import com.abeldevelop.blog.category.service.domain.Category;
import com.abeldevelop.blog.category.service.exception.CategoryExistException;
import com.abeldevelop.blog.category.service.mapper.CategoryMapper;
import com.abeldevelop.blog.category.service.service.v1.CreateCategoryService;
import com.abeldevelop.blog.category.service.util.ErrorCodesConstants;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CreateCategoryServiceImpl implements CreateCategoryService {

	private final CategoryRepository categoryRepository;
	private final CategoryMapper categoryMapper;
	
	@Override
	@Transactional
	public Category executeCreate(Category category) {
		checkIfCategoryExist(category);
		CategoryEntity newCategoryEntity = categoryMapper.mapDomainToEntity(category);
		newCategoryEntity.setState(States.ENABLED);
		return categoryMapper.mapEntityToDomain(categoryRepository.executeSave(newCategoryEntity));
	}
	
	private void checkIfCategoryExist(Category category) {
		Optional<CategoryEntity> categoryEntityOptional = categoryRepository.executeFindById(category.getCode());
		if(categoryEntityOptional.isPresent()) {
			throw new CategoryExistException(ErrorCodesConstants.CATEGORY_CODE_EXIST, Arrays.asList(category.getName()));
		}
	}
}
