package com.example.order_service.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "restaurant-service", url = "http://localhost:8011")
public interface RestaurantServiceProxy {

    @GetMapping(path = "/restaurant/getAllMenuItems")
    ResponseEntity<?> getAllMenuItems();
}
