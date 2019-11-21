package com.abeldevelop.blog.category.service.service.v1.impl;

import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.abeldevelop.architecture.library.pagination.domain.PageIn;
import com.abeldevelop.architecture.library.pagination.domain.PaginationOut;
import com.abeldevelop.architecture.library.pagination.domain.PaginationResult;
import com.abeldevelop.blog.category.model.CategoryEntity;
import com.abeldevelop.blog.category.repository.CategoryRepository;
import com.abeldevelop.blog.category.repository.specification.CategorrySpecifications;
import com.abeldevelop.blog.category.service.domain.Category;
import com.abeldevelop.blog.category.service.mapper.CategoryMapper;
import com.abeldevelop.blog.category.service.service.v1.FindAllCategoriesService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FindAllCategoriesServiceImpl implements FindAllCategoriesService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final CategorrySpecifications categorrySpecifications;
    
    @Override
    public PaginationResult<Category> executeFindAll(PageIn pageRequest, String query) {
        Page<CategoryEntity> categoryEntityPage = categoryRepository.executeFindAll(
                categorrySpecifications.nameLike(query), 
                PageRequest.of(
                        pageRequest.getPagination().getPage(), 
                        pageRequest.getPagination().getSize(), 
                        Sort.by(pageRequest.getSort().getColumn()).descending()));
        
        return new PaginationResult<>(
                PaginationOut.builder()
                .page(categoryEntityPage.getNumber())
                .size(categoryEntityPage.getSize())
                .numberOfElements(categoryEntityPage.getNumberOfElements())
                .totalElements(categoryEntityPage.getTotalElements()).build(),
                categoryEntityPage.getContent().stream().map(categoryMapper::mapEntityToDomain).collect(Collectors.toList()));
    }

}
