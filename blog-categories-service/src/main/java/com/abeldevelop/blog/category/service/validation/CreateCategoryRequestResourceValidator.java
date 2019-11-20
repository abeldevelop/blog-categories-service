package com.abeldevelop.blog.category.service.validation;

import org.springframework.stereotype.Component;

import com.abeldevelop.architecture.library.common.validation.ValidationResource;
import com.abeldevelop.architecture.library.exception.client.ValidationRequestException;
import com.abeldevelop.blog.category.dto.CreateCategoryRequestResource;
import com.abeldevelop.blog.category.service.component.ErrorMessageProperties;

@Component
public class CreateCategoryRequestResourceValidator implements ValidationResource {

    @Override
    public boolean areYouTheElement(String elementName) {
        return CreateCategoryRequestResource.class.getCanonicalName().equals(elementName);
    }

    @Override
    public void validate(Object toValidate) {
        if(toValidate == null) {
            throw new ValidationRequestException(ErrorMessageProperties.CATEGORY_NAME_NOT_NULL);
        }
        CreateCategoryRequestResource createCategoryRequestResource = (CreateCategoryRequestResource) toValidate;
        if(createCategoryRequestResource.getName() == null || createCategoryRequestResource.getName().length() < 3 || createCategoryRequestResource.getName().length() > 25) {
            throw new ValidationRequestException(ErrorMessageProperties.CATEGORY_NAME_SIZE);
        }
    }
}
