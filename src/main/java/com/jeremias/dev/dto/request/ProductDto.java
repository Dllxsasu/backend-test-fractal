package com.jeremias.dev.dto.request;

import com.jeremias.dev.models.Product;

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
	Product  product; 
    private String name;

    private Double price;
    
    private String status;
   

}
