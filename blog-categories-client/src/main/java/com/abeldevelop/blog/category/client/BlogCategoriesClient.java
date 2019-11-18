package com.abeldevelop.blog.category.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.abeldevelop.blog.category.dto.CategoryPaginationResponseResource;
import com.abeldevelop.blog.category.dto.CategoryResponseResource;
import com.abeldevelop.blog.category.dto.CreateCategoryRequestResource;
import com.abeldevelop.blog.category.dto.UpdateCategoryRequestResource;

@FeignClient("blog-categories-service")
public interface BlogCategoriesClient {

    String V1_BASE_REQUEST_MAPPING = "/v1/categories";
    
    @PostMapping(V1_BASE_REQUEST_MAPPING)
    public CategoryResponseResource executeCreate(@RequestBody CreateCategoryRequestResource createCategoryRequestResource);
    
    @PutMapping(V1_BASE_REQUEST_MAPPING + "/{code}")
    public CategoryResponseResource executeUpdate(@PathVariable("code") String code, @RequestBody UpdateCategoryRequestResource updateCategoryRequestResource);
 
    @DeleteMapping(V1_BASE_REQUEST_MAPPING + "/{code}")
    public void executeDelete(@PathVariable("code") String code);
    
    @GetMapping(V1_BASE_REQUEST_MAPPING + "/{code}")
    public CategoryResponseResource executeFindByCode(@PathVariable("code") String code);
    
    @GetMapping(V1_BASE_REQUEST_MAPPING)
    public CategoryPaginationResponseResource executeFindAll(@RequestParam(name = "page", required = false) Integer page, @RequestParam(name = "size", required = false) Integer size, @RequestParam(name = "query", required = false) String query);
    
}
