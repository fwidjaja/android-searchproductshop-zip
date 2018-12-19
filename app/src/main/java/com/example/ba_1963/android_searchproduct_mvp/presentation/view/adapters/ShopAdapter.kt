package com.example.ba_1963.android_searchproduct_mvp.presentation.view.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ba_1963.android_searchproduct_mvp.R
import com.example.ba_1963.android_searchproduct_mvp.presentation.uimodels.shop.ItemShopUiModel
import com.example.ba_1963.android_searchproduct_mvp.util.GlideApp
import kotlinx.android.synthetic.main.list_shop_item.view.*

class ShopAdapter : RecyclerView.Adapter<ShopAdapter.ViewHolder>() {

    val data = mutableListOf<ItemShopUiModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_shop_item, parent, false))
    }

    override fun getItemCount(): Int {
        println("++ size data = ${data.size}")
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.shopName.text = data[position].shopName
        holder.itemView.shopLocation.text = data[position].shopLocation

        if (data[position].shopIcon.isEmpty()) {
            holder.itemView.shopIcon.visibility = View.GONE
        } else {
            holder.itemView.shopIcon.visibility = View.VISIBLE

            GlideApp.with(holder.itemView.shopIcon.context)
                    .load(data[position].shopIcon)
                    .centerCrop()
                    .into(holder.itemView.shopIcon)
        }

        if (data[position].shopReputationIcon.isEmpty()) {
            holder.itemView.shopReputation.visibility = View.GONE
        } else {
            holder.itemView.shopReputation.visibility = View.VISIBLE

            GlideApp.with(holder.itemView.shopReputation.context)
                    .load(data[position].shopReputationIcon)
                    .into(holder.itemView.shopReputation)
        }

        for (i in 0 .. 2) {
            if (data[position].shopProductsIcon[i].isEmpty()) {
                when (i) {
                    0 -> holder.itemView.shopProduct1.visibility = View.GONE
                    1 -> holder.itemView.shopProduct2.visibility = View.GONE
                    3 -> holder.itemView.shopProduct3.visibility = View.GONE
                }
            } else {
                when (i) {
                    0 -> {
                        holder.itemView.shopProduct1.visibility = View.VISIBLE
                        GlideApp.with(holder.itemView.shopProduct1.context)
                                .load(data[position].shopProductsIcon[i])
                                .centerCrop()
                                .into(holder.itemView.shopProduct1) }

                    1 -> {
                        holder.itemView.shopProduct2.visibility = View.VISIBLE
                        GlideApp.with(holder.itemView.shopProduct2.context)
                                .load(data[position].shopProductsIcon[i])
                                .centerCrop()
                                .into(holder.itemView.shopProduct2) }

                    2 -> {
                        holder.itemView.shopProduct3.visibility = View.VISIBLE
                        GlideApp.with(holder.itemView.shopProduct3.context)
                                .load(data[position].shopProductsIcon[i])
                                .centerCrop()
                                .into(holder.itemView.shopProduct3) }
                }
            }
        }
    }

    fun loadShop(newItems: List<ItemShopUiModel>) {
        data.clear()
        data.addAll(newItems)
        notifyDataSetChanged()
    }

    fun loadShopNextPage(newItems: List<ItemShopUiModel>) {
        data.addAll(newItems)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}