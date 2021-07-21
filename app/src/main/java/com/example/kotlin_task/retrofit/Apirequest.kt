package com.example.kotlin_task.retrofit

import com.example.kotlin_task.response.ItemResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET

  interface Apirequest {
      fun enqueue(callback: Callback<ItemResponse?>)

      @get:GET("s/2iodh4vg0eortkl/facts.json")
        val topHeadlines: Call<Any?>?

}