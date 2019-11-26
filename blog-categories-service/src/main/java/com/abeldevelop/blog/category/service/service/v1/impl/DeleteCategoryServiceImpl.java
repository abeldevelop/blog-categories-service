package com.abeldevelop.blog.category.service.service.v1.impl;

import java.util.Arrays;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abeldevelop.architecture.library.property.enums.States;
import com.abeldevelop.blog.category.model.CategoryEntity;
import com.abeldevelop.blog.category.repository.CategoryRepository;
import com.abeldevelop.blog.category.repository.specification.CategorySpecifications;
import com.abeldevelop.blog.category.service.exception.CategoryNotFoundException;
import com.abeldevelop.blog.category.service.service.v1.DeleteCategoryService;
import com.abeldevelop.blog.category.service.util.ErrorCodesConstants;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DeleteCategoryServiceImpl implements DeleteCategoryService {
	
	private final CategoryRepository categoryRepository;
	private final CategorySpecifications categorySpecifications;
	
	@Override
	@Transactional
	public void executeDeleteByCode(String code) {
	    CategoryEntity categoryEntity = checkIfCategoryExist(code);
	    categoryEntity.setState(States.PENDING_TO_DELETED);
		categoryRepository.executeSave(categoryEntity);
	}

	private CategoryEntity checkIfCategoryExist(String code) {
		return categoryRepository.executeFindOne(categorySpecifications.byCode(code)).orElseThrow(() -> new CategoryNotFoundException(ErrorCodesConstants.CATEGORY_NOT_FOUND, Arrays.asList(code)));
	}
}
