package com.company.util;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class InlineButtonUtil {
    public static ReplyKeyboard getFilesTypeButton(){

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        List<InlineKeyboardButton> row2 = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        InlineKeyboardButton button1 = new InlineKeyboardButton("with pdf");
        button1.setCallbackData("pdf");
        InlineKeyboardButton button2 = new InlineKeyboardButton("with excel");
        button2.setCallbackData("excel");
        row1.add(button1);
        row2.add(button2);
        rowList.add(row1);
        rowList.add(row2);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup(rowList);


        return inlineKeyboardMarkup;
    }
}
