package com.example.griddemo.rest;

import com.example.griddemo.data.model.RouteEntity;
import com.example.griddemo.service.RouteService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/routes")
    public Iterable<RouteEntity> getRoutes() {
        return routeService.getRoutes();
    }
}
