package com.sky.pro.Online.store.controller;

import com.sky.pro.Online.store.service.SafeServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/safe")
public class SafeController {

    private final SafeServer safeServer;

    public SafeController(SafeServer safeServer) {
        this.safeServer = safeServer;
    }

    @GetMapping("/status")
    public String safeStatus() {
        return safeServer.safeStatus();
    }

    @GetMapping("/unlock")
    public void status(@RequestParam("pin") int unlock) {
        safeServer.unclock(unlock);
    }

    @GetMapping("/lock")
    public void lock() {
        safeServer.lock();
    }

    @GetMapping("/take-money")
    public String takeMoney(@RequestParam("money") int money) {
        return safeServer.takeMoney(money);
    }

    @GetMapping("/change-pin")
    public String changePin(@RequestParam("oldPin") int oldPin, @RequestParam("newPin") int newPin) {
        return safeServer.changePin(oldPin, newPin);
    }
}
