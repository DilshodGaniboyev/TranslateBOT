package com.company.entity;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {

    @SerializedName("id")
    private Integer id;

    @SerializedName("completed")
    private Boolean completed;

    @SerializedName("title")
    private String title;

    @SerializedName("userId")
    private Integer userId;
}