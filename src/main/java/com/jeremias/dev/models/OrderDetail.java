package com.jeremias.dev.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {
	private String id;
	private String ProductId;
    private Long qty;
    private Double price;
    private Double totalPrice;
}
