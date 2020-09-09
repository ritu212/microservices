package com.example.order_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/order")
public class OrderController {

    @Autowired
    RestaurantServiceProxy restaurantServiceProxy;

    @GetMapping("getMenuItemList")
    public ResponseEntity<?> getMenuItemList() {
        return restaurantServiceProxy.getAllMenuItems();
    }

}
