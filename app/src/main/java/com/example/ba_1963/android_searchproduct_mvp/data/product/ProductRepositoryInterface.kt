package com.example.ba_1963.android_searchproduct_mvp.data.product

import com.example.ba_1963.android_searchproduct_mvp.presentation.models.product.ResponseProductUiModel
import io.reactivex.Observable

interface ProductRepositoryInterface {
    // http://ace.tokopedia.com/search/product/v3?device=android&ob=23&q=baju&rows=12&source=search&start=0
    fun getProductData(device: String, ob: Int, q: String?, rows: Int, source: String, start: Int): Observable<ResponseProductUiModel>
}