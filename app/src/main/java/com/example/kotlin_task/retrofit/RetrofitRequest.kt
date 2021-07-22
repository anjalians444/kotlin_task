package com.example.kotlin_task.retrofit

import com.example.kotlin_task.constanse.AppConstanse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

public class RetrofitRequest {


    companion object {
        private var retrofit: Retrofit? = null
        final fun getRetrofitInstance(): Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(AppConstanse.BASE_URL.URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
    }
    }
