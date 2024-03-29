package com.abeldevelop.blog.category.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ApiModel(description="Create Category resource")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CreateCategoryRequestResource {

	@ApiModelProperty(notes="Name of the category", example="First Category", required = true, position = 0)
	@NotNull
	@Size(min = 3, max = 25)
	private String name;
	
}
