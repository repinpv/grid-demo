package com.example.griddemo.data.repository;

import com.example.griddemo.data.model.CarEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<CarEntity, Long> {
}
