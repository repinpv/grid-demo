package com.example.griddemo.service;

import com.example.griddemo.data.model.RouteEntity;
import com.example.griddemo.data.repository.RouteRepository;
import org.springframework.stereotype.Service;

@Service
public class RouteService {

    private final RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public Iterable<RouteEntity> getRoutes() {
        return routeRepository.findAll();
    }
}
