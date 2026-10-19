package com.sky.pro.Online.store.controller;

import com.sky.pro.Online.store.service.RpgService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rpg")
public class RpgController {
    private final RpgService rpgService;

    public RpgController(RpgService rpgService) {
        this.rpgService = rpgService;
    }
    @GetMapping("/status")
    public String getStatus() {
        return rpgService.getStatus();
    }
    @GetMapping("/go")
    public String makeStep() {
        return rpgService.makeStep();
    }
    @GetMapping("/heal")
    public String heal() {
        return rpgService.heal();
    }

    @GetMapping("/restart")
    public String restart() {
        return rpgService.restart();
    }

}
