package com.jeremias.dev.dto.request;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jeremias.dev.models.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

	private String id;
	private String status;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date date;
	private Double total;	
	List<OrderDetailDto> details;
}
