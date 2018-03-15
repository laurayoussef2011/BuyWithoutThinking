package com.SWEProject.repository;

import com.SWEProject.Entities.Product;
import com.SWEProject.Entities.SystemProduct;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface SystemProductRepository extends CrudRepository<SystemProduct, String>{
}
