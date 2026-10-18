package com.sky.pro.Online.store.service;


import com.sky.pro.Online.store.model.Cart;
import com.sky.pro.Online.store.model.Item;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    private final Cart cart;

    private final Map<Integer, Item> catalog = new HashMap<>();

    public OrderService(Cart cart) {
        this.cart = cart;

        catalog.put(1, new Item(1, "Носки", 150));
        catalog.put(2, new Item(2, "Футболка", 1200));
        catalog.put(3, new Item(3, "Кофе", 450));
        catalog.put(4, new Item(4, "Клавиатура", 5500));

    }

    public void addItems(List<Integer> ids) {
        cart.addItems(ids);
    }

    public List<Integer> getItems() {
        return cart.getItems();
    }

    public void clearCart() {
        cart.clearCart();
    }

    public int getItemsCount() {
        return cart.getItemsCount();
    }

    public void removeItem(Integer id) {
        cart.removeItem(id);
    }

    public int getTotalPraice() {
        int total = 0;

        List<Integer> uzerCartIds = cart.getItems();

        for (Integer id : uzerCartIds) {
            Item item = catalog.get(id);
            if (item != null) {
                total += item.getPrice();
            }
        }
        return total;
    }
}
