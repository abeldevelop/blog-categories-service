package com.abeldevelop.blog.category.service.service.impl;


import org.springframework.stereotype.Component;

import com.abeldevelop.architecture.library.common.error.DefaultErrorMessageService;
import com.abeldevelop.blog.category.service.util.ErrorCodesConstants;

@Component
public class ErrorMessageServiceImpl extends DefaultErrorMessageService {

    public ErrorMessageServiceImpl() {
        addMessagesToMap();
    }

	private void addMessagesToMap() {

	    
	    addMessage(ErrorCodesConstants.REQUEST_FIELD_VALUE_NOT_VALID, "The value {} is not one of those available");
	    addMessage(ErrorCodesConstants.CATEGORY_PAGINATION_RESPONSE_RESOURCE_PAGINATION_RESPONSE_RESOURCE_NOT_NULL, "The pagination cannot be null");
		
	    addMessage(ErrorCodesConstants.CATEGORY_CODE_NOT_NULL, "The category code is mandatory");
	    addMessage(ErrorCodesConstants.CATEGORY_CODE_SIZE, "The category code must be between 3 and 25 characters");
	    addMessage(ErrorCodesConstants.CATEGORY_NAME_NOT_NULL, "The category name is mandatory");
	    addMessage(ErrorCodesConstants.CATEGORY_NAME_SIZE, "The category name must be between 3 and 25 characters");

	    addMessage(ErrorCodesConstants.PAGINATION_MIN_PAGE_ERROR, "The page number can not be less than {}");
	    addMessage(ErrorCodesConstants.PAGINATION_MIN_SIZE_ERROR, "The page size can not be less than {}");
		
	    addMessage(ErrorCodesConstants.CATEGORY_CODE_EXIST, "The Category with name {} already exists");
	    addMessage(ErrorCodesConstants.CATEGORY_NOT_FOUND, "No exist category with code: {}");
		
	}
}
