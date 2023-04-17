package com.jeremias.dev.dto.request;

import com.jeremias.dev.models.Product;

import lombok.Data;

@Data
public class OrderDetailDto {
	String id;
	String idDetail;
	String name;

	long quantity;
	double price;
	double totalPrice;
	int idStatus;
	
	public OrderDetailDto(){
	}
	
}
