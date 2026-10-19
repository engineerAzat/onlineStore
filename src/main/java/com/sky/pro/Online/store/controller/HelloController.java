package com.sky.pro.Online.store.controller;

import com.sky.pro.Online.store.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/say-hello")
    public String sayHello(@RequestParam("name") String user,@RequestParam("nameTwo") String userTwo) {
        return helloService.buildHelloMassage(user, userTwo);
    }

    @GetMapping("/compare-names")
    public String compareNames(@RequestParam("name") String user, @RequestParam("nameTwo") String userTwo) {
        return helloService.compareNames(user, userTwo);

    }

    @GetMapping("/lengths-name")
    public String lengthsName(@RequestParam("name") String user, @RequestParam("nameTwo") String userTwo) {
        return helloService.lengthsName(user, userTwo);
    }

    @GetMapping("/make-nickname")
    public String makeNickname(@RequestParam("nameOne") String userName, @RequestParam("nameTwo") String userNameTwo) {
        return helloService.makeNickname(userName, userNameTwo);
    }

    @GetMapping("/love-detector")
    public String loveDetector(@RequestParam ("name") String user, @RequestParam("nameTwo") String userTwo) {
        return helloService.loveDetector(user, userTwo);
    }

    @GetMapping("/spy-cipher")
    public String spyCipher(@RequestParam("name") String user, @RequestParam("nameTwo") String userTWo) {
        return  helloService.spyCipher(user, userTWo);
    }



    @GetMapping("/click")
    public String click() {

        int currentClick = helloService.incrementAndGet();

        return "Вы нажали на ссылку! Всего кликов: " + currentClick;
    }





}
