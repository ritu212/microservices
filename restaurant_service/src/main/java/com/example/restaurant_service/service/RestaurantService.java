package com.example.restaurant_service.service;


import com.example.restaurant_service.model.Restaurant;
import com.example.restaurant_service.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    public Restaurant addRestaurant(Restaurant restaurant) {
        Restaurant res = null;
        if(Objects.nonNull(restaurant)) {
            res = restaurantRepository.save(restaurant);
        }
        return res;
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }
}
