package com.company.controller;

import com.company.container.ComponentContainer;
import com.company.util.InlineButtonUtil;
import com.company.util.WorkWithFiles;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;

public class Controller {
    public static void handleMessage(Message message){
        SendMessage sendMessage = new SendMessage();
        Long chatId = message.getChatId();
        String text = message.getText();
        if(text.equals("/start")){
            sendMessage.setText("Welcome, "+message.getFrom().getFirstName()+"!");
            sendMessage.setChatId(chatId);
            sendMessage.setReplyMarkup(InlineButtonUtil.getFilesTypeButton());
            ComponentContainer.MY_BOT.sendMsg(sendMessage);
        }

    }


    public static void handleQuery(Message message, String data){
        Long chatId = message.getChatId();
        if(data.equals("")){

        }
        else if(data.equals("")){

        }


    }
}
