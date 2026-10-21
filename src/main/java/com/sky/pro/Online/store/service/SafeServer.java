package com.sky.pro.Online.store.service;

import com.sky.pro.Online.store.model.Safe;
import org.springframework.stereotype.Service;

@Service
public class SafeServer {

    private final Safe safe;

    public SafeServer(Safe safe) {
        this.safe = safe;
    }

    public String safeStatus() {
        safe.safeStatus();
        boolean status = safe.safeStatus();
        int errorsStatus = safe.getErrors();
        if (status && errorsStatus < 3) {
            return "Доступ разрешен! Сейф открыт";
        } else if (errorsStatus >= 3) {
            return "Сейф заблокирован полицией";
        } else {
        return "Доступ запрещен! Сейф закрыт";
        }
    }

    public void unclock(int unlock) {
        safe.safeUnlock(unlock);
    }

    public void lock() {
        safe.safeLock();
    }

    public String takeMoney(int money) {
        int safeMoney = safe.getMoney();
        safe.safeStatus();
        boolean status = safe.safeStatus();
        if (!status) {
            return "Забыл пароль? Сначала открой сейф!";
        } else {
            if (safe.getMoney() >= money) {
                safeMoney = safeMoney - money;
                safe.setMoney(safeMoney);
                return "Итого к выдаче " + money + "$. В сейфе осталось " + safeMoney + "$.";
            } else {
                return "Недостаточно средств!";
            }
        }
    }

    public String changePin(int pin, int newPin) {
        int oldPin = safe.getCurrentPin();
        if (oldPin == pin) {
            safe.setCurrentPin(newPin);
            return "Пароль изменен!";
        } else {
            return "Текущий пароль введен не верно";
        }
    }
}
