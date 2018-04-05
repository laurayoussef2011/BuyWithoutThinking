package com.SWEProject.repository;

import com.SWEProject.Entities.ProductModel;
import org.springframework.data.repository.CrudRepository;

public interface ModelRepository extends CrudRepository<ProductModel,String>{
}
