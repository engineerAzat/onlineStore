package com.sky.pro.Online.store.model;

public class Item {
    private final Integer id;
    private final String name;
    private final int price;

    public Item(Integer id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
