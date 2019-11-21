package com.abeldevelop.blog.category.dto;

public enum CategorySort {

    NAME_DESC("NAME_DESC");
    
    private String value;
    
    private CategorySort(String value) {
        this.value = value;
    }
    
    public String getSort() {
        return value;
    }
    
}
