package com.sky.pro.Online.store.service;

import com.sky.pro.Online.store.model.Hero;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RpgService {
    private final Hero hero;
    private final Random random = new Random();

    public RpgService(Hero hero) {
        this.hero = hero;
    }

    public String getStatus() {
        if (!hero.isAlive()) {
            return "Вы погибли! Введите /rpg/restart, чтобы возродиться.";

        }
        return "Ваш герой жив! Здоровье: \"" + hero.getHealth() + "\"%, Золото: \"" + hero.getGold() + "\" монет.";
    }

    public String makeStep() {
        if (!hero.isAlive()) {
            return " Мертвому герою некуда идти... Начните игру заново (/rpg/restart).";
        }
        int evenType = random.nextInt(3);

        if (evenType == 0) {
            int foundGold = random.nextInt(20) + 10;
            hero.changeGold(foundGold);
            return " Вы нашли заброшенный сундук и забрали " + foundGold + " золотых монет! " + getStatus();
        } else if (evenType == 1) {
            int damage = random.nextInt(15) + 5;
            hero.changeHealth(-damage);
            return " Сработала скрытая ловушка! Вы потеряли " + damage + " здоровья. " + getStatus();
        } else {
            int damage = random.nextInt(25) + 10;
            int reward = random.nextInt(30) + 15;

            hero.changeHealth(-damage);
            if (hero.isAlive()) {
                hero.changeGold(reward);
                return " Вы одолели свирепого гоблина! Получено урона: " + damage + ", добыто золота: " + reward + ". " + getStatus();
            } else {
                return " Гоблин оказался сильнее... Вы получили смертельный урон: " + damage + ". " + getStatus();
            }

        }
    }
    public String heal() {
        if (!hero.isAlive()) {
            return "💀 Магия бессильна над трупом. Начните сначала.";
        }
        if (hero.getGold() < 20) {
            return "❌ У вас недостаточно золота! Нужно хотя бы 20 монет. " + getStatus();
        }
        if (hero.getHealth() >= 100) {
            return "❤️ Вы полностью здоровы! " + getStatus();
        }

        hero.changeGold(-20);
        hero.changeHealth(30);
        return "🧪 Вы выпили целебное зелье за 20 монет! Восстановлено 30 здоровья. " + getStatus();
    }

    public String restart() {
        hero.changeHealth(100); // Сбрасываем здоровье до максимума
        hero.changeGold(-hero.getGold()); // Обнуляем всё золото
        return "✨ Вы возродились у костра! Начните новое приключение (/rpg/go).";
    }

}
