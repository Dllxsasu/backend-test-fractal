package com.jeremias.dev.dto.request;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	@NotBlank(message = "Status cannot be blank")
	private String status;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Date cannot be null")
	private Date date;
	private double total;	
	List<OrderDetailDto> details;
}
