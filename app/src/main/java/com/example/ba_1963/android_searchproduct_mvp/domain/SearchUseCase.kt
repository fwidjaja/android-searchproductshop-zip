package com.example.ba_1963.android_searchproduct_mvp.domain

import com.example.ba_1963.android_searchproduct_mvp.data.product.ProductRepositoryInterface
import com.example.ba_1963.android_searchproduct_mvp.data.shop.ShopRepositoryInterface
import com.example.ba_1963.android_searchproduct_mvp.presentation.models.product.ResponseProductUiModel
import com.example.ba_1963.android_searchproduct_mvp.presentation.models.shop.ResponseShopUiModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchUseCase @Inject constructor(private val productRepository: ProductRepositoryInterface, private val shopRepository: ShopRepositoryInterface){
    fun getDataProducts(device: String, ob: Int, q: String?, rows: Int, source: String, start: Int): Observable<ResponseProductUiModel> {
        return this.productRepository.getProductData(device, ob, q, rows, source, start)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun getDataShops(device: String, q: String?, rows: Int, source: String, start: Int): Observable<ResponseShopUiModel> {
        return this.shopRepository.getShopData(device, q, rows, source, start)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}