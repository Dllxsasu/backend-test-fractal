package com.jeremias.dev.dto.request;

import com.jeremias.dev.models.Product;

import lombok.Data;

@Data
public class OrderDetailDto {
	String productId;
	Product product;
	long Qty;
	double price;
	boolean active;
	boolean _new;
	boolean update;
}
