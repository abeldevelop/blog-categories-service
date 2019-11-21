package com.abeldevelop.blog.category.service.mapper;

import org.springframework.stereotype.Component;

import com.abeldevelop.architecture.library.pagination.domain.SortDirection;
import com.abeldevelop.architecture.library.pagination.domain.SortIn;
import com.abeldevelop.architecture.library.pagination.mapper.CommonSortDirectionMapper;
import com.abeldevelop.blog.category.dto.CategorySort;

//TODO => Make generic and move to common-library
//Something like common factory. And the mappers have a map key: NAME_DESC value: new SortIn(SortDirection.DESC, "name")
@Component
public class CategorySortMapper extends CommonSortDirectionMapper<CategorySort> {

    @Override
    public SortIn map(CategorySort enumSort) {
        if(enumSort != null) {
            if(CategorySort.NAME_DESC.getSort().equals(enumSort.getSort())) {
                return new SortIn(SortDirection.DESC, "name");
            }
        }
        //Default Sort
        return new SortIn(SortDirection.DESC, "name");
    }

}
