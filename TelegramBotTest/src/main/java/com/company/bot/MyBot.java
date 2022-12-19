package com.company.bot;

import com.company.container.ComponentContainer;
import com.company.controller.Controller;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ForwardMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return ComponentContainer.BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return ComponentContainer.BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            Controller.handleMessage(message);
        }else if(update.hasCallbackQuery()){
            CallbackQuery callbackQuery = update.getCallbackQuery();
            Message message = callbackQuery.getMessage();
            String data = callbackQuery.getData();
            Controller.handleQuery(message,data);
        }
    }


    public void sendMsg(Object obj) {
        try {
            if (obj instanceof SendMessage sendMessage) {
                execute(sendMessage);
            }
            else if (obj instanceof EditMessageText editMessageText) {
                execute(editMessageText);
            }
            else if (obj instanceof DeleteMessage deleteMessage) {
                execute(deleteMessage);
            }
            else if (obj instanceof SendPhoto sendPhoto) {
                execute(sendPhoto);
            }
            else if (obj instanceof SendDocument sendDocument) {
                execute(sendDocument);
            }
            else if (obj instanceof ForwardMessage forwardMessage) {
                execute(forwardMessage);
            }
            else if (obj instanceof EditMessageReplyMarkup editMessageReplyMarkup) {
                execute(editMessageReplyMarkup);
            }

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
