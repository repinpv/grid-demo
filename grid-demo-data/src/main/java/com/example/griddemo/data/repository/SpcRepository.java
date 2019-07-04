package com.example.griddemo.data.repository;

import com.example.griddemo.data.model.SpcEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpcRepository extends CrudRepository<SpcEntity, Long> {
}
