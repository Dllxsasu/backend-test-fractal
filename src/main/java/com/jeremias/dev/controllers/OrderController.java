package com.jeremias.dev.controllers;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeremias.dev.dto.request.OrderDto;
import com.jeremias.dev.mappers.OrderMapper;
import com.jeremias.dev.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
	private final OrderService service;
	private final OrderMapper mapper;
	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody OrderDto dto) {
		return new ResponseEntity<>( mapper.toDto( service.create(dto)), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") String id, @Valid @RequestBody OrderDto dto) {
		System.out.println(id);
		return new ResponseEntity<>(mapper.toDto(service.update(id, dto)), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<?> findAll() {
		return new ResponseEntity<>(service.getAll().stream()
				.map(mapper::toDto).collect(Collectors.toList())
				
				, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") String id) {
		return new ResponseEntity<>(mapper.toDto(service.getById(id)), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") String id) {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
