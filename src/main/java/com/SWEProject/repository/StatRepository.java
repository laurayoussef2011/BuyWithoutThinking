package com.SWEProject.repository;

import com.SWEProject.Entities.Statistics;
import org.springframework.data.repository.CrudRepository;

public interface StatRepository extends CrudRepository<Statistics, String > {
}
