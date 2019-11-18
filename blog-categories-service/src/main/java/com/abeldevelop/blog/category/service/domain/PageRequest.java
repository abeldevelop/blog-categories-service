package com.abeldevelop.blog.category.service.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@Getter
@ToString
public class PageRequest {

	private PaginationRequest pagination;
	private SortRequest sort;
}
