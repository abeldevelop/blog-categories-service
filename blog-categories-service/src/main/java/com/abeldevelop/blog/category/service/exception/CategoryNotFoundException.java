package com.abeldevelop.blog.category.service.exception;

import java.util.List;

import com.abeldevelop.architecture.library.exception.client.NotFoundException;

public class CategoryNotFoundException extends NotFoundException {

	private static final long serialVersionUID = -3086561586413180261L;

	public CategoryNotFoundException(String message) {
		super(message);
	}

	public CategoryNotFoundException(String message, List<Object> arguments) {
		super(message, arguments);
	}
	
	public CategoryNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public CategoryNotFoundException(String message, List<Object> arguments, Throwable cause) {
		super(message, arguments, cause);
	}
}
