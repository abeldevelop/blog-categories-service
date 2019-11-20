package com.abeldevelop.blog.category.service.validation;

import org.springframework.stereotype.Component;

import com.abeldevelop.blog.category.dto.UpdateCategoryRequestResource;
import com.abeldevelop.blog.category.service.component.impl.ErrorMessageProperties;
import com.abeldevelop.blog.category.service.component.validation.ValidationResource;
import com.abeldevelop.blog.category.service.exception.client.custom.ValidationRequestException;

@Component
public class UpdateCategoryRequestResourceValidator implements ValidationResource {

    @Override
    public boolean areYouTheElement(String elementName) {
        return UpdateCategoryRequestResource.class.getCanonicalName().equals(elementName);
    }

    @Override
    public void validate(Object toValidate) {
        if(toValidate == null) {
            throw new ValidationRequestException(ErrorMessageProperties.CATEGORY_NAME_NOT_NULL);
        }
        UpdateCategoryRequestResource updateCategoryRequestResource = (UpdateCategoryRequestResource) toValidate;
        if(updateCategoryRequestResource.getName() == null || updateCategoryRequestResource.getName().length() < 3 || updateCategoryRequestResource.getName().length() > 25) {
            throw new ValidationRequestException(ErrorMessageProperties.CATEGORY_NAME_SIZE);
        }
    }
    
}
