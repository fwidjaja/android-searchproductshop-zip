package com.example.ba_1963.android_searchproduct_mvp.data.shop

import com.example.ba_1963.android_searchproduct_mvp.api.Api
import com.example.ba_1963.android_searchproduct_mvp.domain.mapper.ProductMapper
import com.example.ba_1963.android_searchproduct_mvp.domain.mapper.ShopMapper
import com.example.ba_1963.android_searchproduct_mvp.presentation.models.product.ResponseProductUiModel
import com.example.ba_1963.android_searchproduct_mvp.presentation.models.shop.ResponseShopUiModel
import io.reactivex.Observable
import javax.inject.Inject

@Suppress("UNCHECKED_CAST", "SENSELESS_COMPARISON")
class ShopRepository @Inject constructor(private val remoteShopDataSource: Api): ShopRepositoryInterface {
    override fun getShopData(device: String, q: String?, rows: Int, source: String, start: Int): Observable<ResponseShopUiModel> {
        return remoteShopDataSource.searchShop(device, q, rows, source, start)
                .map { ShopMapper.responseToUiModel(it) }
                .filter { it != null } as Observable<ResponseShopUiModel>
    }
}