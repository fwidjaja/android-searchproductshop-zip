package com.example.ba_1963.android_searchproduct_mvp.data.shop

import com.example.ba_1963.android_searchproduct_mvp.presentation.models.shop.ResponseShopUiModel
import io.reactivex.Observable

interface ShopRepositoryInterface {
    // http://ace.tokopedia.com/search/v1/shop?device=android&q=baju&rows=12&source=search&start=0
    fun getShopData(device: String, q: String?, rows: Int, source: String, start: Int): Observable<ResponseShopUiModel>
}