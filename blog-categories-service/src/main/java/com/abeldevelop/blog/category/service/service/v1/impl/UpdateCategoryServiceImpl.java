package com.abeldevelop.blog.category.service.service.v1.impl;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.abeldevelop.blog.category.model.CategoryEntity;
import com.abeldevelop.blog.category.repository.CategoryRepository;
import com.abeldevelop.blog.category.service.domain.Category;
import com.abeldevelop.blog.category.service.exception.CategoryExistException;
import com.abeldevelop.blog.category.service.exception.CategoryNotFoundException;
import com.abeldevelop.blog.category.service.mapper.CategoryMapper;
import com.abeldevelop.blog.category.service.service.v1.UpdateCategoryService;
import com.abeldevelop.blog.category.service.util.ErrorCodesConstants;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UpdateCategoryServiceImpl implements UpdateCategoryService {

	private final CategoryRepository categoryRepository;
	private final CategoryMapper categoryMapper;
	
	
	@Override
	public Category executeUpdate(String code, Category category) {
		checkIfCategoryExist(code);
		checkIfNewCategoryExist(category);
		
		categoryRepository.executeDeleteById(code);
		return categoryMapper.mapEntityToDomain(categoryRepository.executeSave(categoryMapper.mapDomainToEntity(category)));
	}
	
	private void checkIfCategoryExist(String code) {
		Optional<CategoryEntity> categoryEntityOptional = categoryRepository.executeFindById(code);
		if(!categoryEntityOptional.isPresent()) {
			throw new CategoryNotFoundException(ErrorCodesConstants.CATEGORY_NOT_FOUND, Arrays.asList(code));
		}
	}
	
	private void checkIfNewCategoryExist(Category category) {
		Optional<CategoryEntity> categoryEntityOptional = categoryRepository.executeFindById(category.getCode());
		if(categoryEntityOptional.isPresent()) {
			throw new CategoryExistException(ErrorCodesConstants.CATEGORY_CODE_EXIST, Arrays.asList(category.getName()));
		}
	}
	
}
