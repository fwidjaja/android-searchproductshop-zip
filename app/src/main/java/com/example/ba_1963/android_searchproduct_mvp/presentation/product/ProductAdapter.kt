package com.example.ba_1963.android_searchproduct_mvp.presentation.product

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ba_1963.android_searchproduct_mvp.R
import com.example.ba_1963.android_searchproduct_mvp.presentation.models.product.ProductsItemUiModel
import com.example.ba_1963.android_searchproduct_mvp.util.GlideApp
import kotlinx.android.synthetic.main.list_product_item.view.*

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    val data = mutableListOf<ProductsItemUiModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_product_item, parent, false))
    }

    override fun getItemCount(): Int {
        println("++ size data = ${data.size}")
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.itemName.text = data[position].name
        holder.itemView.itemPrice.text = data[position].price

        if (data[position].imageUrl.isNullOrEmpty()) {
            holder.itemView.itemImg.visibility = View.GONE
        } else {
            holder.itemView.itemImg.visibility = View.VISIBLE

            GlideApp.with(holder.itemView.itemImg.context)
                    .load(data[position].imageUrl)
                    .centerCrop()
                    .into(holder.itemView.itemImg)
        }
    }

    fun loadProduct(newItems: List<ProductsItemUiModel>) {
        data.clear()
        data.addAll(newItems)
        notifyDataSetChanged()
    }

    fun loadProductNextPage(newItems: List<ProductsItemUiModel>) {
        data.addAll(newItems)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}