package com.abeldevelop.blog.category.service.mapper;

import org.springframework.stereotype.Component;

import com.abeldevelop.architecture.library.common.util.StringUtils;
import com.abeldevelop.blog.category.dto.CategoryResponseResource;
import com.abeldevelop.blog.category.dto.CreateCategoryRequestResource;
import com.abeldevelop.blog.category.dto.UpdateCategoryRequestResource;
import com.abeldevelop.blog.category.model.CategoryEntity;
import com.abeldevelop.blog.category.service.domain.Category;

@Component
public class CategoryMapper {

	public Category mapResourceToDomain(CreateCategoryRequestResource createCategoryRequestResource) {
		return Category.builder()
				.code(StringUtils.generateUrlName(createCategoryRequestResource.getName()))
				.name(createCategoryRequestResource.getName())
				.build();
	}
	
	public Category mapResourceToDomain(UpdateCategoryRequestResource updateCategoryRequestResource) {
		return Category.builder()
				.code(StringUtils.generateUrlName(updateCategoryRequestResource.getName()))
				.name(updateCategoryRequestResource.getName())
				.build();
	}
	
	public CategoryEntity mapDomainToEntity(Category category) {
		return CategoryEntity.builder()
				.code(category.getCode())
				.name(category.getName())
				.build();
	}
	
	public Category mapEntityToDomain(CategoryEntity categoryEntity) {
		return Category.builder()
				.code(categoryEntity.getCode())
				.name(categoryEntity.getName())
				.build();
	}
	
	public CategoryResponseResource mapDomainToResource(Category category) {
		return CategoryResponseResource.builder()
				.code(category.getCode())
				.name(category.getName())
				.build();
	}
	
}
