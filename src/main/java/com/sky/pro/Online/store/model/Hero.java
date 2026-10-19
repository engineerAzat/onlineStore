package com.sky.pro.Online.store.model;


import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Hero {
    private  int health = 100;
    private int gold = 0;

    public int getHealth() {
        return health;
    }

    public int getGold() {
        return gold;
    }

    public void changeHealth(int amout) {
        this.health += amout;
        if (this.health > 100)
            this.health = 100;
        if(this.health < 0)
            this.health = 0;
    }

    public void changeGold(int amout) {
        this.gold += amout;
        if (this.gold < 0)
            this.gold = 0;
    }

    public boolean isAlive() {
        return this.health > 0;
    }
}
