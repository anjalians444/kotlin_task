package com.example.kotlin_task.repositry

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlin_task.response.ItemResponse
import com.example.kotlin_task.retrofit.Apirequest
import com.example.kotlin_task.retrofit.RetrofitRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItemRepositry {
    private val TAG: String =
      ItemRepositry::class.java.getSimpleName()
    private var apiRequest: Apirequest? = null


    fun ItemRepositry() {
        apiRequest = RetrofitRequest.getRetrofitInstance()?.create(Apirequest::class.java)
    }

    fun getItemResponse(): LiveData<ItemResponse?>? {
        val data: MutableLiveData<ItemResponse?> = MutableLiveData<ItemResponse?>()
        apiRequest?.getTopHeadlines()
            .enqueue(object : Callback<ItemResponse?> {
                override fun onResponse(
                    call: Call<ItemResponse?>,
                    response: Response<ItemResponse?>
                ) {
                    if (response.body() != null) {
                        data.setValue(response.body())
                    }
                }

                override fun onFailure(call: Call<ItemResponse?>, t: Throwable) {
                    data.setValue(null)
                }
            })
        return data
    }
}

private fun Any?.enqueue(callback: Callback<ItemResponse?>) {

}


