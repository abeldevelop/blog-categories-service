package com.abeldevelop.blog.category.service.exception;

import java.util.List;

import com.abeldevelop.architecture.library.exception.client.BadRequestException;

public class CategoryExistException extends BadRequestException {

	private static final long serialVersionUID = -3086561586413180261L;

	public CategoryExistException(String message) {
		super(message);
	}

	public CategoryExistException(String message, List<Object> arguments) {
		super(message, arguments);
	}
	
	public CategoryExistException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public CategoryExistException(String message, List<Object> arguments, Throwable cause) {
		super(message, arguments, cause);
	}
}
