package com.abeldevelop.blog.category.service.service.v1;

import com.abeldevelop.architecture.library.pagination.domain.PageIn;
import com.abeldevelop.architecture.library.pagination.domain.PaginationResult;
import com.abeldevelop.blog.category.service.domain.Category;

public interface FindAllCategoriesService {

    public PaginationResult<Category> executeFindAll(PageIn pageRequest, String query);
    
}
