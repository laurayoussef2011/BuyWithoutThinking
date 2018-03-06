package com.SWEProject.repository;

import com.SWEProject.Entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, String> {
}
