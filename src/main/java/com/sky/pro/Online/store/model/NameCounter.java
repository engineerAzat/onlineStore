package com.sky.pro.Online.store.model;


import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashMap;
import java.util.Map;

@Component
@SessionScope
public class NameCounter {
    private final Map<String, Integer> likesMap = new HashMap<>();

    public void addLike(String name) {

        int currentLikes = likesMap.getOrDefault(name, 0);
        likesMap.put(name, currentLikes + 1);
    }

    public Map<String, Integer> getAllLikes() {
        return likesMap;
    }

}
