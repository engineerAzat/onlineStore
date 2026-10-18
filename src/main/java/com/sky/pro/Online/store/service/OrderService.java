package com.sky.pro.Online.store.service;


import com.sky.pro.Online.store.model.Cart;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final Cart cart;

    public OrderService(Cart cart) {
        this.cart = cart;
    }

    public void addItems(List<Integer> ids) {
        cart.addItems(ids);
    }

    public List<Integer> getItems() {
        return cart.getItems();
    }
}
