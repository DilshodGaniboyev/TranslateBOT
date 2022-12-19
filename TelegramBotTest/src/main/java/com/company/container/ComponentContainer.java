package com.company.container;

import com.company.bot.MyBot;

public interface ComponentContainer {
    String BOT_TOKEN = "";
    String BOT_USERNAME = "";

    MyBot MY_BOT = new MyBot();
}
