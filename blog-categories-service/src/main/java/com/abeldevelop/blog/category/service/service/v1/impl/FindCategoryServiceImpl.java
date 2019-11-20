package com.abeldevelop.blog.category.service.service.v1.impl;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.abeldevelop.blog.category.model.CategoryEntity;
import com.abeldevelop.blog.category.repository.CategoryRepository;
import com.abeldevelop.blog.category.repository.specification.CategorrySpecifications;
import com.abeldevelop.blog.category.service.component.ErrorMessageProperties;
import com.abeldevelop.blog.category.service.domain.Category;
import com.abeldevelop.blog.category.service.domain.PageRequest;
import com.abeldevelop.blog.category.service.domain.PaginationResponse;
import com.abeldevelop.blog.category.service.domain.PaginationResult;
import com.abeldevelop.blog.category.service.exception.CategoryNotFoundException;
import com.abeldevelop.blog.category.service.mapper.CategoryMapper;
import com.abeldevelop.blog.category.service.service.v1.FindCategoryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FindCategoryServiceImpl implements FindCategoryService {
	
	private final CategoryRepository categoryRepository;
	private final CategoryMapper categoryMapper;
	private final CategorrySpecifications categorrySpecifications;
	
	@Override
	public Category executeFindByCode(String code) {
		Optional<CategoryEntity> categoryEntityOptional = categoryRepository.executeFindById(code);
		if(!categoryEntityOptional.isPresent()) {
			throw new CategoryNotFoundException(ErrorMessageProperties.CATEGORY_NOT_FOUND, Arrays.asList(code));
		}
		return categoryMapper.mapEntityToDomain(categoryEntityOptional.get());
	}

	@Override
	public PaginationResult<Category> executeFindAll(PageRequest pageRequest, String query) {
		Page<CategoryEntity> categoryEntityPage = categoryRepository.executeFindAll(
		        categorrySpecifications.nameLike(query), 
		        org.springframework.data.domain.PageRequest.of(
		                pageRequest.getPagination().getPage(), 
		                pageRequest.getPagination().getSize(), 
		                Sort.by(pageRequest.getSort().getColumn()).descending()));
		
		return new PaginationResult<>(
		        PaginationResponse.builder()
		        .page(categoryEntityPage.getNumber())
		        .size(categoryEntityPage.getSize())
		        .numberOfElements(categoryEntityPage.getNumberOfElements())
		        .totalElements(categoryEntityPage.getTotalElements()).build(),
				categoryEntityPage.getContent().stream().map(categoryMapper::mapEntityToDomain).collect(Collectors.toList()));
	}
	
}
