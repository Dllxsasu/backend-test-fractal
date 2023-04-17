package com.jeremias.dev.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jeremias.dev.dto.request.ProductDto;
import com.jeremias.dev.exceptions.ResourceNotFoundException;
import com.jeremias.dev.mappers.ProductMapper;
import com.jeremias.dev.models.Product;
import com.jeremias.dev.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class ProductService {
	final ProductRepository repo;
	final ProductMapper mapper;
	public Product create( ProductDto request) {
		final String uuid = UUID.randomUUID().toString();
		return repo.save( mapper.toEntity(request, uuid) );
		
	}
	
	public void delete(String id) {
		
		repo.deleteById(id);
	}

	public Product update(String id, ProductDto obj) {
		Product objU = getById(id);
		objU.setName(obj.getName());
		objU.setPrice(obj.getPrice());
		
		return repo.save(objU);
	}

	public List<Product> getAll() {
		return repo.findAll();
	}

	public Product getById(String id) {
		return repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("The product with the id was not found, id:" + id));
	}
}
