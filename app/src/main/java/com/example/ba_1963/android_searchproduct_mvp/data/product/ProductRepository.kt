package com.example.ba_1963.android_searchproduct_mvp.data.product

import com.example.ba_1963.android_searchproduct_mvp.api.Api
import com.example.ba_1963.android_searchproduct_mvp.domain.mapper.ProductMapper
import com.example.ba_1963.android_searchproduct_mvp.presentation.models.product.ResponseProductUiModel
import io.reactivex.Observable
import javax.inject.Inject

@Suppress("UNCHECKED_CAST", "SENSELESS_COMPARISON")
class ProductRepository @Inject constructor(private val remoteProductDataSource: Api): ProductRepositoryInterface {
    override fun getProductData(device: String, ob: Int, q: String?, rows: Int, source: String, start: Int): Observable<ResponseProductUiModel> {
        return remoteProductDataSource.searchProduct(device, ob, q, rows, source, start)
                .map { ProductMapper.responseToUiModel(it) }
                .filter { it != null } as Observable<ResponseProductUiModel>
    }
}