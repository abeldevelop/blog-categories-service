package com.abeldevelop.blog.category.service.service.v1;

import com.abeldevelop.blog.category.service.domain.Category;
import com.abeldevelop.blog.category.service.domain.PageRequest;
import com.abeldevelop.blog.category.service.domain.PaginationResult;

public interface FindCategoryService {

	public Category executeFindByCode(String code);
	
	public PaginationResult<Category> executeFindAll(PageRequest pageRequest, String query);
	
}
