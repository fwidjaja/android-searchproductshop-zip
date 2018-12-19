package com.example.ba_1963.android_searchproduct_mvp.model.repositories

import com.example.ba_1963.android_searchproduct_mvp.model.services.ApiService
import com.example.ba_1963.android_searchproduct_mvp.domain.mapper.ProductMapper
import com.example.ba_1963.android_searchproduct_mvp.presentation.uimodels.product.ProductsItemUiModel
import io.reactivex.Observable
import javax.inject.Inject

@Suppress("UNCHECKED_CAST", "SENSELESS_COMPARISON")
class ProductRepository @Inject constructor(private val remoteProductDataSource: ApiService): ProductRepositoryInterface {
    override fun getProductData(device: String, ob: Int, q: String?, rows: Int, source: String, start: Int): Observable<List<ProductsItemUiModel>> {
        return remoteProductDataSource.searchProduct(device, ob, q, rows, source, start)
            .map { ProductMapper.responseToListUiModel(it) }
            .filter { it != null }
    }
}