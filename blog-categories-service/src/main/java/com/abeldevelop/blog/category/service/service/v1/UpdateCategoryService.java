package com.abeldevelop.blog.category.service.service.v1;

import com.abeldevelop.blog.category.service.domain.Category;

public interface UpdateCategoryService {

	public Category executeUpdate(String code, Category category);
	
}
