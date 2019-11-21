package com.abeldevelop.blog.category.service.validation;

import org.springframework.stereotype.Component;

import com.abeldevelop.architecture.library.common.validation.ValidationResource;
import com.abeldevelop.architecture.library.exception.client.ValidationRequestException;
import com.abeldevelop.blog.category.dto.UpdateCategoryRequestResource;
import com.abeldevelop.blog.category.service.util.ErrorCodesConstants;

@Component
public class UpdateCategoryRequestResourceValidator implements ValidationResource {

    @Override
    public boolean areYouTheElement(String elementName) {
        return UpdateCategoryRequestResource.class.getCanonicalName().equals(elementName);
    }

    @Override
    public void validate(Object toValidate) {
        if(toValidate == null) {
            throw new ValidationRequestException(ErrorCodesConstants.CATEGORY_NAME_NOT_NULL);
        }
        UpdateCategoryRequestResource updateCategoryRequestResource = (UpdateCategoryRequestResource) toValidate;
        if(updateCategoryRequestResource.getName() == null) {
            throw new ValidationRequestException(ErrorCodesConstants.CATEGORY_NAME_NOT_NULL);
        }
        if(updateCategoryRequestResource.getName().length() < 3 || updateCategoryRequestResource.getName().length() > 25) {
            throw new ValidationRequestException(ErrorCodesConstants.CATEGORY_NAME_SIZE);
        }
    }
    
}
