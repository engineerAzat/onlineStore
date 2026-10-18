package com.sky.pro.Online.store.controller;

import com.sky.pro.Online.store.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/store/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/add")
    public void addItems(@RequestParam("id") List<Integer> ids) {
        orderService.addItems(ids);
    }

    @GetMapping("/get")
    public List<Integer> getItems() {
        return orderService.getItems();
    }
}
