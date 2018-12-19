package com.example.ba_1963.android_searchproduct_mvp.model.repositories

import com.example.ba_1963.android_searchproduct_mvp.model.services.ApiService
import com.example.ba_1963.android_searchproduct_mvp.domain.mapper.ShopMapper
import com.example.ba_1963.android_searchproduct_mvp.presentation.uimodels.shop.ItemShopUiModel
import io.reactivex.Observable
import javax.inject.Inject

@Suppress("UNCHECKED_CAST", "SENSELESS_COMPARISON")
class ShopRepository @Inject constructor(private val remoteShopDataSource: ApiService): ShopRepositoryInterface {
    override fun getShopData(device: String, q: String?, rows: Int, source: String, start: Int): Observable<List<ItemShopUiModel>> {
            return remoteShopDataSource.searchShop(device, q, rows, source, start)
                .map { ShopMapper.responseToListUiModel(it) }
                .filter { it != null }
    }
}