package com.sky.pro.Online.store.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Safe {
    private boolean safeStatus = false;
    private int money = 5_000;
    private int errors = 0;
    private int currentPin = 1234;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getErrors() {
        return errors;
    }

    public int getCurrentPin() {
        return currentPin;
    }

    public void setCurrentPin(int currentPin) {
        this.currentPin = currentPin;
    }

    public void safeUnlock(int unlock) {
        if (unlock == currentPin) {
            safeStatus = true;
        } else {
            errors = errors + 1;
        }
    }

    public boolean safeStatus() {
        if (!safeStatus) {
            return false;
        } else {
            return true;
        }
    }

    public void safeLock() {
        safeStatus = false;
    }


}
