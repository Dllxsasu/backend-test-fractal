package com.jeremias.dev.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
	
	private String id;
	@NotBlank( message = "name cannot be blank")
    private String name;
	@NotNull
	@Min(value = 1, message = "Price must be at least 1")
    private Double price;      
}
