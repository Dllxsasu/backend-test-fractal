package com.jeremias.dev.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.jeremias.dev.dto.request.ProductDto;
import com.jeremias.dev.models.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {




	@Mapping(target = "id", source = "id")
	public Product toEntity(ProductDto dto, String id);

	

	@Mapping(target = "id", source = "obj.id")
	public ProductDto toDto(Product obj);
}
