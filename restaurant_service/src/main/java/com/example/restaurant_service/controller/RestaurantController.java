package com.example.restaurant_service.controller;

import com.example.restaurant_service.dto.MenuItemDto;
import com.example.restaurant_service.dto.RestaurantDto;
import com.example.restaurant_service.model.MenuItem;
import com.example.restaurant_service.model.Restaurant;
import com.example.restaurant_service.service.MenuItemService;
import com.example.restaurant_service.service.RestaurantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController("/restaurant")
public class RestaurantController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    MenuItemService menuItemService;

    @PostMapping("/addRestaurant")
    public ResponseEntity<?> addRestaurant(@RequestBody RestaurantDto restaurantDto) {
        Restaurant restaurant = modelMapper.map(restaurantDto, Restaurant.class);
        restaurant = restaurantService.addRestaurant(restaurant);
        if(Objects.nonNull(restaurant)) {
            return new ResponseEntity<>(restaurant, HttpStatus.ACCEPTED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllRestaurants")
    public ResponseEntity<?> getAllRestaurants() {
        List<Restaurant> restaurantList = restaurantService.getAllRestaurants();
        if(restaurantList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<>(restaurantList, HttpStatus.OK);
        }
    }

    @PostMapping("/createMenuItem")
    public ResponseEntity<?> createMenuItem(@RequestBody MenuItemDto menuItemDto) {
        MenuItem menuItem = modelMapper.map(menuItemDto, MenuItem.class);
        menuItem = menuItemService.createMenuItem(menuItem);
        if(Objects.nonNull(menuItem)) {
            return new ResponseEntity<>(menuItem, HttpStatus.ACCEPTED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllMenuItems")
    public ResponseEntity<?> getAllMenuItems() {
        List<MenuItem> menuItemList = menuItemService.getAllMenuItems();
        if(menuItemList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<>(menuItemList, HttpStatus.OK);
        }
    }

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
