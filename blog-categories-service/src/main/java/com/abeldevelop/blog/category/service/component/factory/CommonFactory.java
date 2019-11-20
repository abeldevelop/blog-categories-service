package com.abeldevelop.blog.category.service.component.factory;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class CommonFactory<T extends FactoryElement> {

    @Autowired
    private List<T> elements;

    public Optional<T> getElement(String elementName) {
        boolean found = false;
        int index = 0;
        if(elements == null || elements.isEmpty()) {
            return Optional.empty();
        }
        while(index < elements.size() && !found) {
            found = elements.get(index).areYouTheElement(elementName);
            index++;
        }
        if(!found) {
            return Optional.empty();
        } else {
            return Optional.of(elements.get(index-1));
        }
    }
    
}
