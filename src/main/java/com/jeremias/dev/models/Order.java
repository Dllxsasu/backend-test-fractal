package com.jeremias.dev.models;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
@Document
@ToString
@Data	
public class Order {
	@Getter
	@EqualsAndHashCode.Include
	private final String id;
	private Long orderId;
	//private String consumer;
	private OrderStatus status;
	private Date date;
	private Double total;
	private List<OrderDetail> details;
}
