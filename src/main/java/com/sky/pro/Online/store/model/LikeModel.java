package com.sky.pro.Online.store.model;


import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class LikeModel {

    private  int likes = 0;

    public void addLike() {
        this.likes += 1;
    }

    public int getLikes() {

      return this.likes;


    }

    public void delLike() {
        this.likes -= 1;
        if (this.likes < 0) {
            this.likes = 0;
        }
    }

    public void resetLike() {
        this.likes = 0;
    }
}
