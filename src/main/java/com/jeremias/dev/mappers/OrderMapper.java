package com.jeremias.dev.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeremias.dev.dto.request.OrderDetailDto;
import com.jeremias.dev.dto.request.OrderDto;
import com.jeremias.dev.models.Order;
import com.jeremias.dev.models.OrderDetail;
import com.jeremias.dev.service.ProductService;

@Mapper(componentModel = "spring")
public abstract class OrderMapper {
	@Autowired
	private ProductService productService;
	
	@Mapping(target = "details", source = "details")
	@Mapping(target = "id", source = "id")
	public abstract Order toEntity(OrderDto dto, List<OrderDetail> details, String id);
	
	
	

//public OrderDto toDto(Order obj);
	public OrderDto toDto(Order obj) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(obj.getId());
        orderDto.setStatus(obj.getStatus().name());
        orderDto.setDate(obj.getDate());
        orderDto.setTotal(obj.getTotal());
        
        List<OrderDetailDto> orderDetailsDto = obj.getDetails().stream().map(orderDetail -> {
            OrderDetailDto orderDetailDto = new OrderDetailDto();
            orderDetailDto.setProductId(orderDetail.getProductId());
            orderDetailDto.setQty(orderDetail.getQty());
            orderDetailDto.setPrice(orderDetail.getPrice() );
            orderDetailDto.setProduct(productService.getById(orderDetail.getProductId()));
            return orderDetailDto;
        }).collect(Collectors.toList());

        orderDto.setDetails(orderDetailsDto);
        return orderDto;
    }
}
