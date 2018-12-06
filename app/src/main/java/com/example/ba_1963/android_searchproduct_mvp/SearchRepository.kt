package com.example.ba_1963.android_searchproduct_mvp

import com.example.ba_1963.android_searchproduct_mvp.api.API
import com.example.ba_1963.android_searchproduct_mvp.model.data.ResultSearchDataModel
import com.example.ba_1963.android_searchproduct_mvp.model.ui.DataItemUiModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchRepository : SearchDataSource {
    private var isLoading = false
    override fun getData(
        q: String?, start: Int, onSuccess: (
            List<DataItemUiModel>?
        ) -> Unit
    ) {
        if (isLoading) return
        isLoading = true
        API.instance.getSearch(q, start).enqueue(object : Callback<ResultSearchDataModel?> {
            override fun onResponse(call: Call<ResultSearchDataModel?>, response: Response<ResultSearchDataModel?>) {
                val searchResponse = response.body()

                val datas = searchResponse?.datas?.let { datasRaw ->
                    datasRaw
                            .map { it.toUiModel() }
                            .filter { it != null }
                            .map { it!! }
                }

                onSuccess(datas)
                isLoading = false

            }

            override fun onFailure(call: Call<ResultSearchDataModel?>, t: Throwable) {
                isLoading = false
            }
        })
    }
}