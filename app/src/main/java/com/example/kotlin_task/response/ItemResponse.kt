package com.example.kotlin_task.response

import com.example.kotlin_task.Model.ItemModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

public class ItemResponse {
    fun getArticalModels():List<ItemModel?>?{
        return itemModel

    }

    companion object {
        @SerializedName("rows")
        @Expose
        private var itemModel: List<ItemModel?>? = null
        fun getArticalModels(): List<ItemModel?>? {
            return itemModel
        }

        fun setArticalModels(itemModels: List<ItemModel?>?) {
            this.itemModel = itemModels
        }

        override fun toString(): String {
            return "ItemResponse{" +
                    "itemModels=" + itemModel +
                    '}'
        }
    }
}
