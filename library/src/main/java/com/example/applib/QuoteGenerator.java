package com.example.applib;

import org.springframework.stereotype.Service;

@Service
public class QuoteGenerator {

    public QuoteGenerator() {}

    final String[] quotes = new String[]{
            "«Моя мама всегда говорила: «Жизнь как коробка шоколадных конфет: " +
            "никогда не знаешь, какая начинка тебе попадётся». © Форрест Гамп",
            "«Хьюстон, у нас проблема». © Аполлон 13",
            "«Ложки нет». © Матрица",
            "«Ничего не понимаю! Или что-то случилось, или одно из двух!» © Следствие ведут Колобки"};

    public String getQuote() {
        return quotes[(int) (Math.random() * quotes.length)];
    }

}
