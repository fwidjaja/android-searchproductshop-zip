package com.example.ba_1963.android_searchproduct_mvp.model.repositories

import com.example.ba_1963.android_searchproduct_mvp.presentation.uimodels.product.ProductsItemUiModel
import io.reactivex.Single

interface ProductRepositoryInterface {
    // http://ace.tokopedia.com/search/product/v3?device=android&ob=23&q=baju&rows=12&source=search&start=0
    fun getProductData(device: String, ob: Int, q: String?, rows: Int, source: String, start: Int): Single<List<ProductsItemUiModel>>
}