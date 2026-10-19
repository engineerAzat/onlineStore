package com.sky.pro.Online.store.controller;

import com.sky.pro.Online.store.service.LikeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/like-system")
public class LikeController {

    private final LikeService likeService;
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping("/add")
    public String likeName(@RequestParam("name") String name) {
        return likeService.likeName(name);
    }

    @GetMapping("/stats")
    public Map<String, Integer> getStats() {
        return likeService.getStats();
    }
}
