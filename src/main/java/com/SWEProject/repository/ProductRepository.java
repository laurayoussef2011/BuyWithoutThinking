package com.SWEProject.repository;

import com.SWEProject.Entities.Product;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
