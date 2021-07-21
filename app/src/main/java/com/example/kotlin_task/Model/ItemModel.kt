package com.example.kotlin_task.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

public class ItemModel(
    @field:Expose @field:SerializedName("urlToImage") var image: String,
    @field:Expose @field:SerializedName(
        "title"
    ) var title: String,
    @field:Expose @field:SerializedName("description") var des: String,
    @field:Expose @field:SerializedName(
        "imageHref"
    ) var url: String, )
{

    override fun toString(): String {
        return "ItemModel{" +
                "image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", des='" + des + '\'' +
                '}'
    }
}