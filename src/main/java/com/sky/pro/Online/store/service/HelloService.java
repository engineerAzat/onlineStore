package com.sky.pro.Online.store.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String buildHelloMassage(String n1, String n2) {
        return "Приветствую почтенных " + n1 + " и " + n2 + "!";
    }

    public String compareNames(String user, String userTwo) {
        int len1 = user.length();
        int len2 = userTwo.length();

        if (len1 > len2) {
            int difference = len1 - len2;
            return "Имя " + user + " длиннее, чем имя " + userTwo + " на " + difference + " букв(ы).";
        } else if (len2 > len1) {
            int difference = len2 - len1;
            return "Имя " + userTwo + " длиннее, чем имя " + user + " на " + difference + " букв(ы).";
        } else {
            return "Невероятно! Имена " + user + " и " + userTwo + " абсолютно одинаковой длины (" + len1 + " букв).";
        }
    }

    public String lengthsName(String user, String userTwo) {
        int len1 = user.length();
        int len2 = userTwo.length();
        int sum = len1 + len2;
        return "Количество букв в имени " + user + ": " + len1 +", а количество букв в имени"
                + userTwo + ": " + len2 + ". Суммарное количество букв: " +  sum;
    }

    public String makeNickname(String user, String userNameTwo) {
        String nameInRevers = new StringBuilder(user).reverse().toString();
        return "xX_" + nameInRevers + "_" + userNameTwo + "_Xx";
    }

    public String loveDetector(String user, String userTwo) {
        int len1 = user.length();
        int len2 = userTwo.length();
        int sum = len1 + len2;
        if (sum > 10) {
            while (sum > 10) {
                sum -= 10;
            }
        }
        sum = sum * 10;

        if (80 < sum && sum <= 100) {
            return "Совместимость " + user + " и " + userTwo + " составляет " + sum + "%! Идеальная пара!";

        } else if (40 <= sum && sum <= 80) {
            return "Совместимость " + user + " и " + userTwo + " составляет " + sum + "%! Хорошая пара!";
        } else {
            return "Совместимость " + user + " и " + userTwo + " составляет " + sum + "%! Плохая пара!";
        }
    }

    public String spyCipher(String user, String userTwo) {

        String result1 = user.replaceAll("(?iu)[аоеия]", "*");
        String result2 = userTwo.replaceAll("(?iu)[аоеия]", "*");

        return "Зашифрованные имена: " + result1 + " и " + result2;
    }

    private int count = 0;

    public int incrementAndGet() {
        count += 1;
        return count;
    }
}
