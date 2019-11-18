package com.abeldevelop.blog.category.service.component;

import java.util.Optional;

public interface ErrorMessages {

	public Optional<String> getErrorMessage(String code);
	
}
