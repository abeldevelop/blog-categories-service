package com.abeldevelop.blog.category.service.service.v1.impl;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.abeldevelop.blog.category.model.CategoryEntity;
import com.abeldevelop.blog.category.repository.CategoryRepository;
import com.abeldevelop.blog.category.service.domain.Category;
import com.abeldevelop.blog.category.service.exception.CategoryNotFoundException;
import com.abeldevelop.blog.category.service.mapper.CategoryMapper;
import com.abeldevelop.blog.category.service.service.v1.FindCategoryByCodeService;
import com.abeldevelop.blog.category.service.util.ErrorCodesConstants;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FindCategoryByCodeServiceImpl implements FindCategoryByCodeService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    
    @Override
    public Category executeFindByCode(String code) {
        Optional<CategoryEntity> categoryEntityOptional = categoryRepository.executeFindById(code);
        if(!categoryEntityOptional.isPresent()) {
            throw new CategoryNotFoundException(ErrorCodesConstants.CATEGORY_NOT_FOUND, Arrays.asList(code));
        }
        return categoryMapper.mapEntityToDomain(categoryEntityOptional.get());
    }
    
}