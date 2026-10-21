package com.sky.pro.Online.store.controller;

import com.sky.pro.Online.store.service.LikeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/cat")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping("/like")
    public String putLike() {
        return likeService.addLikeGetText();
    }

    @GetMapping("/status")
    public String showStatus() {
        return likeService.getCurrentLikesText();
    }

    @GetMapping("/del-like")
    public String delLike() {
        return likeService.delLikeGetText();
    }

    @GetMapping("/reset-like")
    public String resetLike() {
        return likeService.resetLikeGetText();
    }
}
