package com.sky.pro.Online.store.service;

import com.sky.pro.Online.store.model.NameCounter;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LikeService {

    private final NameCounter nameCounter;

    public LikeService(NameCounter nameCounter) {
        this.nameCounter = nameCounter;
    }

    public String likeName(String name) {
        nameCounter.addLike(name);

        int currentLikes = nameCounter.getAllLikes().get(name);
        return "Вы лайкнули имя " + name + "! Теперь у него лайков: " + currentLikes;

    }

    public Map<String, Integer> getStats() {
        return nameCounter.getAllLikes();
    }
}
