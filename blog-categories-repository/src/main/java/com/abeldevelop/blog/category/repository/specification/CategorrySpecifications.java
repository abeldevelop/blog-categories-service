package com.abeldevelop.blog.category.repository.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.abeldevelop.blog.category.model.CategoryEntity;
import com.abeldevelop.blog.category.model.CategoryEntity_;

@Component
public class CategorrySpecifications {

    public Specification<CategoryEntity> nameLike(String query) {
        return (root, criteriaQuery, criteriaBuilder) -> { 
            return criteriaBuilder.like(
                    criteriaBuilder.upper(root.get(CategoryEntity_.name)), 
                    "%" + query.toUpperCase() + "%");
        };
    }
    
}
