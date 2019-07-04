package com.example.griddemo.data.repository;

import com.example.griddemo.data.model.RouteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends CrudRepository<RouteEntity, Long> {
}
