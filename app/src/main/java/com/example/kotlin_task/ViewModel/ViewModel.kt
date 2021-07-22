package com.example.kotlin_task.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.kotlin_task.repositry.ItemRepositry
import com.example.kotlin_task.response.ItemResponse


class ViewModel(application: Application) : AndroidViewModel(application) {
    private var articalRepository: ItemRepositry? = null
    private var articalResponseLiveData: LiveData<ItemResponse?>? = null

    fun ViewModel(applications: Application) {
      // super(applications)
        applications
        articalRepository = ItemRepositry()
        articalResponseLiveData = articalRepository!!.getItemResponse()
    }

    fun getArticalResponseLiveData(): LiveData<ItemResponse?>? {
        return articalResponseLiveData
    }
}