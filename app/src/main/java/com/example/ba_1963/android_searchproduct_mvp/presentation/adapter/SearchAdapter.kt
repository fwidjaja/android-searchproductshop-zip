package com.example.ba_1963.android_searchproduct_mvp.presentation.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ba_1963.android_searchproduct_mvp.R
import com.example.ba_1963.android_searchproduct_mvp.presentation.models.DataItemUiModel
import com.example.ba_1963.android_searchproduct_mvp.util.GlideApp
import kotlinx.android.synthetic.main.list_item.view.*

class SearchAdapter : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    val data = mutableListOf<DataItemUiModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
    }

    override fun getItemCount(): Int {
        println("++ size data = ${data.size}")
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.itemName.text = data[position].itemName
        holder.itemView.itemPrice.text = data[position].itemPrice

        if (data[position].itemImg.isNullOrEmpty()) {
            holder.itemView.itemImg.visibility = View.GONE
        } else {
            holder.itemView.itemImg.visibility = View.VISIBLE

            GlideApp.with(holder.itemView.itemImg.context)
                    .load(data[position].itemImg)
                    .centerCrop()
                    .into(holder.itemView.itemImg)
        }
    }

    fun updateData(newData: List<DataItemUiModel>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    fun loadNextPage(newItems: List<DataItemUiModel>) {
        data.addAll(newItems)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}