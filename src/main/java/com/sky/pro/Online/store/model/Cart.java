package com.sky.pro.Online.store.model;


import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class Cart {
    private final List<Integer> items = new ArrayList<>();

    public void addItems(List<Integer> ids) {
        if (ids != null) {
            this.items.addAll(ids);
        }

    }

    public List<Integer> getItems() {
        return items;
    }

    public void clearCart() {
        this.items.clear();
    }

    public int getItemsCount() {
        return this.items.size();
    }

    public void removeItem(Integer id) {
        if (id != null) {
            this.items.remove(Integer.valueOf(id));
        }
    }
}
