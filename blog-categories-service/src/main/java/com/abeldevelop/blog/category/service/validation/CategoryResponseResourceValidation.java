package com.abeldevelop.blog.category.service.validation;

import org.springframework.stereotype.Component;

import com.abeldevelop.architecture.library.common.validation.ValidationResource;
import com.abeldevelop.blog.category.dto.CategoryResponseResource;
import com.abeldevelop.blog.category.service.component.ErrorMessageProperties;
import com.abeldevelop.blog.category.service.exception.client.custom.ValidationRequestException;
import com.abeldevelop.blog.category.service.exception.server.custom.ValidationResponseException;

@Component
public class CategoryResponseResourceValidation implements ValidationResource {

    @Override
    public boolean areYouTheElement(String elementName) {
        return CategoryResponseResource.class.getCanonicalName().equals(elementName);
    }

    @Override
    public void validate(Object toValidate) {
        if(toValidate == null) {
            throw new ValidationRequestException(ErrorMessageProperties.CATEGORY_CODE_NOT_NULL);
        }
        CategoryResponseResource categoryResponseResource = (CategoryResponseResource) toValidate;
        if(categoryResponseResource.getCode() == null || categoryResponseResource.getCode().length() < 3 || categoryResponseResource.getCode().length() > 25) {
            throw new ValidationResponseException(ErrorMessageProperties.CATEGORY_CODE_SIZE);
        }
        if(categoryResponseResource.getName() == null || categoryResponseResource.getName().length() < 3 || categoryResponseResource.getName().length() > 25) {
            throw new ValidationResponseException(ErrorMessageProperties.CATEGORY_NAME_SIZE);
        }
    }
}
