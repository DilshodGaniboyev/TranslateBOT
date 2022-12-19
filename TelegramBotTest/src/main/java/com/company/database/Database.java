package com.company.database;

import com.company.entity.Todo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class Database {


    public static List<Todo> getTodos() {

        List<Todo> todos = new ArrayList<>();
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/todos");

            URLConnection urlConnection = url.openConnection();


            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            Gson gson = new Gson();

            Type type = new TypeToken<List<Todo>>(){}.getType();
            todos = gson.fromJson(reader,type);


        } catch (IOException e) {
            e.printStackTrace();

        }
        return todos;
    }
}
