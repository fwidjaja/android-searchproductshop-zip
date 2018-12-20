package com.example.ba_1963.android_searchproduct_mvp.model.repositories

import com.example.ba_1963.android_searchproduct_mvp.model.services.ApiService
import com.example.ba_1963.android_searchproduct_mvp.domain.mapper.ShopMapper
import com.example.ba_1963.android_searchproduct_mvp.presentation.uimodels.shop.ItemShopUiModel
import io.reactivex.Single
import javax.inject.Inject

class ShopRepository @Inject constructor(private val apiService: ApiService): ShopRepositoryInterface {
    override fun getShopData(device: String, q: String?, rows: Int, source: String, start: Int): Single<List<ItemShopUiModel>> {
            return apiService.searchShop(device, q, rows, source, start)
                .map { ShopMapper.responseToListUiModel(it) }
    }
}