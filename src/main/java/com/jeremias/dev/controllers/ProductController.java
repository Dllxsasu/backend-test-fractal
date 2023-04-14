package com.jeremias.dev.controllers;

import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

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

import com.jeremias.dev.dto.request.ProductDto;
import com.jeremias.dev.mappers.ProductMapper;
import com.jeremias.dev.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
	private final ProductService service;
	private final ProductMapper mapper;
	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody ProductDto dto) {
		return new ResponseEntity<>( mapper.toDto( service.create(dto)), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") String id, @Valid @RequestBody ProductDto dto) {
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
		System.out.println("id: " + id);
		return new ResponseEntity<>(mapper.toDto(service.getById(id)), HttpStatus.OK);
	}

	@DeleteMapping()
	public ResponseEntity<?> delete(@PathVariable("id") String id) {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
