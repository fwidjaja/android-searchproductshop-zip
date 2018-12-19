package com.example.ba_1963.android_searchproduct_mvp.model.repositories

import com.example.ba_1963.android_searchproduct_mvp.presentation.uimodels.shop.ItemShopUiModel
import io.reactivex.Observable
import io.reactivex.Single

interface ShopRepositoryInterface {
    // http://ace.tokopedia.com/search/v1/shop?device=android&q=baju&rows=12&source=search&start=0
    fun getShopData(device: String, q: String?, rows: Int, source: String, start: Int): Observable<List<ItemShopUiModel>>
}