package com.example.restaurant_service.service;

import com.example.restaurant_service.model.MenuItem;
import com.example.restaurant_service.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MenuItemService {

    @Autowired
    MenuItemRepository menuItemRepository;

    public MenuItem createMenuItem(MenuItem menuItem) {
        MenuItem item = null;
        if(Objects.nonNull(menuItem)) {
            item = menuItemRepository.save(menuItem);
        }
        return item;
    }

    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }
}
