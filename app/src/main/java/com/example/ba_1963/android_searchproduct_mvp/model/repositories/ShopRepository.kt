package com.example.ba_1963.android_searchproduct_mvp.model.repositories

import com.example.ba_1963.android_searchproduct_mvp.model.services.ApiService
import com.example.ba_1963.android_searchproduct_mvp.domain.mapper.ShopMapper
import com.example.ba_1963.android_searchproduct_mvp.presentation.uimodels.shop.ItemShopUiModel
import com.example.ba_1963.android_searchproduct_mvp.presentation.uimodels.shop.ResponseShopUiModel
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

@Suppress("UNCHECKED_CAST", "SENSELESS_COMPARISON", "CAST_NEVER_SUCCEEDS")
class ShopRepository @Inject constructor(private val remoteShopDataSource: ApiService): ShopRepositoryInterface {
    override fun getShopData(device: String, q: String?, rows: Int, source: String, start: Int): Single<List<ItemShopUiModel>> {
        return Single.fromObservable { _ ->
            remoteShopDataSource.searchShop(device, q, rows, source, start)
                .map { ShopMapper.responseToListUiModel(it) }
                .filter { it != null } }
    }
}