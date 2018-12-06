package com.example.ba_1963.android_searchproduct_mvp.util

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.ba_1963.android_searchproduct_mvp.SearchPresenter

class ScrollListener(val layoutManager: GridLayoutManager, val itemPresenter: SearchPresenter, val query: String, val currPage: Int) : RecyclerView.OnScrollListener() {
    var previousTotal = 0
    var loading = true
    val visibleThreshold = 10
    var firstVisibleItem = 0
    var visibleItemCount = 0
    var totalItemCount = 0

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        visibleItemCount = recyclerView.childCount
        totalItemCount = layoutManager.itemCount
        firstVisibleItem = layoutManager.findFirstVisibleItemPosition()

        if (loading) {
            if (totalItemCount > previousTotal) {
                loading = false
                previousTotal = totalItemCount
            }
        }

        if (!loading && (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold)) {
            // val initialSize = dataList.size
            itemPresenter.search(query, currPage+1)
            // val updatedSize = dataList.size
            // recyclerView.post { adapter.notifyItemRangeInserted(initialSize, updatedSize) }
            loading = true
        }
    }
}