package com.abeldevelop.blog.category.service.component.validation;

import com.abeldevelop.blog.category.service.component.factory.FactoryElement;

public interface ValidationResource extends FactoryElement {

    public void validate(Object toValidate);
    
}
