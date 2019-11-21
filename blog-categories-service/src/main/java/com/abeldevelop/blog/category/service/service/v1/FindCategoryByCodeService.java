package com.abeldevelop.blog.category.service.service.v1;

import com.abeldevelop.blog.category.service.domain.Category;

public interface FindCategoryByCodeService {

    public Category executeFindByCode(String code);
    
}
