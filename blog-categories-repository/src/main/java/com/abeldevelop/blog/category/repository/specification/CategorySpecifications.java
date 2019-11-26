package com.abeldevelop.blog.category.repository.specification;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.abeldevelop.architecture.library.property.enums.States;
import com.abeldevelop.blog.category.model.CategoryEntity;
import com.abeldevelop.blog.category.model.CategoryEntity_;

@Component
public class CategorySpecifications {

    public Specification<CategoryEntity> nameLike(String query) {
        return (root, criteriaQuery, criteriaBuilder) -> { 
            return criteriaBuilder.like(
                    criteriaBuilder.upper(root.get(CategoryEntity_.name)), 
                    "%" + query.toUpperCase() + "%");
        };
    }
    
    public Specification<CategoryEntity> stateEnabled() {
        return (root, criteriaQuery, criteriaBuilder) -> { 
            return criteriaBuilder.equal(root.get(CategoryEntity_.state), States.ENABLED);
        };
    }
    
    public Specification<CategoryEntity> byCode(String code) {
        return (root, criteriaQuery, criteriaBuilder) -> { 
            Predicate statePredicate = criteriaBuilder.equal(root.get(CategoryEntity_.state), States.ENABLED);
            Predicate idPredicate = criteriaBuilder.equal(root.get(CategoryEntity_.code), code);
            return criteriaBuilder.and(statePredicate, idPredicate);
        };
    }
}
