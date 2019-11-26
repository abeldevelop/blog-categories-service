package com.abeldevelop.blog.category.service.service.v1.impl;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abeldevelop.blog.category.model.CategoryEntity;
import com.abeldevelop.blog.category.repository.CategoryRepository;
import com.abeldevelop.blog.category.repository.specification.CategorySpecifications;
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
    private final CategorySpecifications categorySpecifications;
    
    @Override
    @Transactional(readOnly = true)
    public Category executeFindByCode(String code) {
        Optional<CategoryEntity> categoryEntityOptional = categoryRepository.executeFindOne(categorySpecifications.byCode(code));
        if(!categoryEntityOptional.isPresent()) {
            throw new CategoryNotFoundException(ErrorCodesConstants.CATEGORY_NOT_FOUND, Arrays.asList(code));
        }
        return categoryMapper.mapEntityToDomain(categoryEntityOptional.get());
    }
    
}
