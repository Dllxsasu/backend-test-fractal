package com.jeremias.dev.mappers;

import com.jeremias.dev.dto.request.ProductDto;
import com.jeremias.dev.dto.request.ProductDto.ProductDtoBuilder;
import com.jeremias.dev.models.Product;
import com.jeremias.dev.models.Product.ProductBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-17T01:57:55-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toEntity(ProductDto dto, String id) {
        if ( dto == null && id == null ) {
            return null;
        }

        ProductBuilder product = Product.builder();

        if ( dto != null ) {
            product.name( dto.getName() );
            product.price( dto.getPrice() );
        }
        if ( id != null ) {
            product.id( id );
        }

        return product.build();
    }

    @Override
    public ProductDto toDto(Product obj) {
        if ( obj == null ) {
            return null;
        }

        ProductDtoBuilder productDto = ProductDto.builder();

        productDto.id( obj.getId() );
        productDto.name( obj.getName() );
        productDto.price( obj.getPrice() );

        return productDto.build();
    }
}
