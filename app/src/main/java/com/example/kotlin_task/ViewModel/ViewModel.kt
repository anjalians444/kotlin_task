package com.example.kotlin_task.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.kotlin_task.repositry.ItemRepositry
import com.example.kotlin_task.response.ItemResponse


class ViewModel(application: Application) : AndroidViewModel(application) {
    private val articalRepository: ItemRepositry
    private val articalResponseLiveData: LiveData<ItemResponse>
    fun getArticalResponseLiveData(): LiveData<ItemResponse> {
        return articalResponseLiveData
    }

    init {
        articalRepository = ItemRepositry()
        articalResponseLiveData = articalRepository.getItemResponse()
    }
}
