package com.abeldevelop.blog.category.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(CategoryEntity.class)
public class CategoryEntity_ {

	public static volatile SingularAttribute<CategoryEntity, String> code;
	public static volatile SingularAttribute<CategoryEntity, String> name;
	
}
