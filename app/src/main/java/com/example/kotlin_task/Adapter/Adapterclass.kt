package com.example.kotlin_task.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin_task.Model.ItemModel
import com.example.kotlin_task.R
import java.util.ArrayList


class Adapterclass(
    private val context: Context,
    modelArrayList: ArrayList<ItemModel>?,
    itemClickListener: ItemClickListener
) :
    RecyclerView.Adapter<Adapterclass.MyViewHolder>() {
    var modelArrayList: ArrayList<ItemModel>?
    private val clickListener: ItemClickListener
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_adapter, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val model:ItemModel = modelArrayList!![position]
        holder.des.setText(model.des)
        holder.title.setText(model.title)
        holder.itemView.setOnClickListener { clickListener.onItemclick(modelArrayList!![position]) }
        Glide.with(context)
            .load(model.image)
            .into(holder.imageView)

        //    Toast.makeText(context,""+modelArrayList.size(),Toast.LENGTH_LONG).show();
    }

    override fun getItemCount(): Int {
        return if (modelArrayList != null) {
            modelArrayList!!.size
        } else 0
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView
        var des: TextView
        var imageView: ImageView

        init {
            title = itemView.findViewById(R.id.news_title)
            des = itemView.findViewById(R.id.news_des)
            imageView = itemView.findViewById(R.id.imageView)
        }
    }

    interface ItemClickListener {
        fun onItemclick(item: ItemModel?)
    }

    init {
        this.modelArrayList = modelArrayList
        clickListener = itemClickListener
    }
}