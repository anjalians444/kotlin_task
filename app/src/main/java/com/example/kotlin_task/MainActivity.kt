package com.example.kotlin_task

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_task.Adapter.Adapterclass
import com.example.kotlin_task.Model.ItemModel
import com.example.kotlin_task.ViewModel.ViewModel
import java.util.*
import java.util.EnumSet.of
import java.util.List.of
import java.util.Set.of
import java.util.stream.Collector.of

class MainActivity : AppCompatActivity(), Adapterclass.ItemClickListener {
    private var recyclerView: RecyclerView? = null
    private var layoutManager: LinearLayoutManager? = null
    private var progressBar: ProgressBar? = null
    private var nodatafound: TextView? = null
    private val articalModelArrayList: ArrayList<ItemModel> = ArrayList<ItemModel>()
    var articalViewModel: ViewModel? = null
    private var madapter: Adapterclass? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initi()
        artical
    }

    private fun initi() {
        recyclerView = findViewById(R.id.recyclerView)
        progressBar = findViewById(R.id.progress)
        nodatafound = findViewById(R.id.noResultTv)
        progressBar?.setVisibility(View.VISIBLE)
        layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView?.setLayoutManager(layoutManager)
        recyclerView?.setHasFixedSize(true)
        madapter = Adapterclass(this@MainActivity, articalModelArrayList, this)
        recyclerView?.setAdapter(madapter)
        articalViewModel = ViewModelProvider.(this).get(ViewModel::class.java)
    }

    private val artical: Unit
        private get() {
            articalViewModel?.getArticalResponseLiveData()?.observe(this) { articalResponse ->
                progressBar!!.visibility = View.VISIBLE
                if (articalResponse != null && articalResponse.getArticalModels()
                    != null && !articalResponse.getArticalModels()!!
                        .isEmpty()
                ) {
                    progressBar!!.visibility = View.GONE
                    nodatafound!!.visibility = View.GONE
                    val articalList: List<ItemModel> =
                        articalResponse.getArticalModels() as List<ItemModel>
                    articalModelArrayList.addAll(articalList)
                    madapter?.notifyDataSetChanged()
                } else {
                    progressBar!!.visibility = View.GONE
                    nodatafound!!.visibility = View.VISIBLE
                }
            }
        }


    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    override fun onItemclick(item: ItemModel?) {
        Toast.makeText(this, "Clicked Title Name is : " +item?.title, Toast.LENGTH_SHORT).show();

    }
}