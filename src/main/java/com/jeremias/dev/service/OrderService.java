package com.jeremias.dev.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jeremias.dev.dto.request.OrderDetailDto;
import com.jeremias.dev.dto.request.OrderDto;
import com.jeremias.dev.exceptions.ResourceNotFoundException;
import com.jeremias.dev.mappers.OrderMapper;
import com.jeremias.dev.models.Order;
import com.jeremias.dev.models.OrderDetail;
import com.jeremias.dev.models.OrderStatus;
import com.jeremias.dev.models.Product;
import com.jeremias.dev.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderService {
	final OrderRepository repo;
	final ProductService productService;
	final OrderMapper orderMapper;

	public Order create(OrderDto request) {
		final String uuid = UUID.randomUUID().toString();
		List<OrderDetail> details = request.getDetails().stream().map(item -> {
			Product product = productService.getById(item.getId());
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setId(UUID.randomUUID().toString());
			orderDetail.setProductId(item.getId());
			orderDetail.setPrice(product.getPrice());
			orderDetail.setTotalPrice(product.getPrice() * item.getQuantity());
			orderDetail.setQty(item.getQuantity());
			return orderDetail;

		}).collect(Collectors.toList());
		Order obj = orderMapper.toEntity(request, details, uuid);
		double total = details.stream().mapToDouble(OrderDetail::getTotalPrice).sum();
		obj.setTotal(total);
		return repo.save(obj);

	}

	public void delete(String id) {
		repo.deleteById(id);
	}

	public Order update(String id, OrderDto request) {
		Order objU = getById(id);
		// get list for delete
		List<OrderDetail> detailsO = objU.getDetails();

	    // Delete
	    detailsO.removeIf(detail -> request.getDetails().stream()
	            .anyMatch(item -> item.getIdStatus()==-1 && item.getIdDetail().equals(detail.getId())));


		// add
		List<OrderDetail> detailsNew = request.getDetails().stream().filter(item -> item.getIdStatus() == 0).map(item -> {
			Product product = productService.getById(item.getId());
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setId(UUID.randomUUID().toString());
			orderDetail.setProductId(item.getId());
			orderDetail.setPrice(product.getPrice());
			orderDetail.setTotalPrice(product.getPrice() * item.getQuantity());
			orderDetail.setQty(item.getQuantity());
			return orderDetail;

		}).collect(Collectors.toList());
		detailsO.addAll(detailsNew);

		// Update

		request.getDetails().stream().filter(item -> item.getIdStatus()==2).forEach(item -> updateDetail(detailsO, item));

		double total = detailsO.stream().mapToDouble(OrderDetail::getTotalPrice).sum();
		objU.setStatus( Enum.valueOf( OrderStatus.class, request.getStatus() ) );
		objU.setDetails(detailsO);
		objU.setTotal(total);
//
		return repo.save(objU);
	}

	

	private void updateDetail(List<OrderDetail> listDetail, OrderDetailDto item) {

var x=	 listDetail.stream().map(detail -> {
			if (detail.getId().equals(item.getIdDetail())) {
				detail.setId(item.getId());
				detail.setProductId(item.getId());
				detail.setTotalPrice(detail.getPrice() * item.getQuantity()); // actualizar el precio total del detalle de
																			// orden
				detail.setQty(item.getQuantity());
			}
			return detail;
		}).collect(Collectors.toList());
var t = x;
	}

	public List<Order> getAll() {
		return repo.findAll();
	}

	public Order getById(String id) {
		return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order with id:" + id + " not found"));
	}

}
