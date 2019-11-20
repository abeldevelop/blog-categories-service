package com.abeldevelop.blog.category.service.component.validation;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.abeldevelop.blog.category.service.component.factory.CommonFactory;

@Component
public class ValidationFactory extends CommonFactory<ValidationResource> {

    public void validate(Object toValidate) {
        Optional<ValidationResource> element = super.getElement(toValidate.getClass().getCanonicalName());
        if(element.isPresent()) {
            element.get().validate(toValidate);
        } else {
            throw new IllegalArgumentException("No exist validator for class: " + toValidate.getClass().getCanonicalName());
        }
    }
}
