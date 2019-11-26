package com.abeldevelop.blog.category.service.service.v1.impl;

import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abeldevelop.architecture.library.pagination.domain.PageIn;
import com.abeldevelop.architecture.library.pagination.domain.PaginationResult;
import com.abeldevelop.architecture.library.pagination.mapper.PaginationMapper;
import com.abeldevelop.blog.category.model.CategoryEntity;
import com.abeldevelop.blog.category.repository.CategoryRepository;
import com.abeldevelop.blog.category.repository.specification.CategorySpecifications;
import com.abeldevelop.blog.category.service.domain.Category;
import com.abeldevelop.blog.category.service.mapper.CategoryMapper;
import com.abeldevelop.blog.category.service.mapper.CategorySortMapper;
import com.abeldevelop.blog.category.service.service.v1.FindAllCategoriesService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FindAllCategoriesServiceImpl implements FindAllCategoriesService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final CategorySpecifications categorySpecifications;
    private final CategorySortMapper categorySortMapper;
    private final PaginationMapper paginationMapper;
    
    @Override
    @Transactional(readOnly = true)
    public PaginationResult<Category> executeFindAll(PageIn pageIn, String query) {
        Page<CategoryEntity> categoryEntityPage = findAll(pageIn, query);
        return new PaginationResult<>(
                paginationMapper.mapPageToPaginationOut(categoryEntityPage),
                categoryEntityPage.getContent().stream().map(categoryMapper::mapEntityToDomain).collect(Collectors.toList()));
    }

    private Page<CategoryEntity> findAll(PageIn pageIn, String query) {
        PageRequest pageRequest = PageRequest.of(pageIn.getPagination().getPage(), pageIn.getPagination().getSize(), categorySortMapper.map(pageIn.getSort()));
        if(query == null || query.isEmpty()) {
            return categoryRepository.executeFindAll(categorySpecifications.stateEnabled(), pageRequest);
        } else {
            return categoryRepository.executeFindAll(categorySpecifications.nameLike(query).and(categorySpecifications.stateEnabled()), pageRequest);
        }
    }
    
}
