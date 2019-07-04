package com.example.griddemo.data.repository;

import com.example.griddemo.data.model.CollectorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectorRepository extends CrudRepository<CollectorEntity, Long> {
}
