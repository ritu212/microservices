package com.example.restaurant_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuItemDto {

    private Long restaurantId;
    private String itemName;
    private String itemDescription;
    private Double itemPrice;
}
