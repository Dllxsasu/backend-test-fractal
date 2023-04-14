package com.jeremias.dev.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {
	@Getter
	@EqualsAndHashCode.Include
	private final String id;
	private String name;
	private Double price;


}
