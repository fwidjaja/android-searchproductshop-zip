package com.example.ba_1963.android_searchproduct_mvp.domain

import com.example.ba_1963.android_searchproduct_mvp.model.repositories.ProductRepositoryInterface
import com.example.ba_1963.android_searchproduct_mvp.model.repositories.ShopRepositoryInterface
import com.example.ba_1963.android_searchproduct_mvp.presentation.uimodels.ProductsAndShopsUiModel
import com.example.ba_1963.android_searchproduct_mvp.presentation.uimodels.product.ProductsItemUiModel
import com.example.ba_1963.android_searchproduct_mvp.presentation.uimodels.shop.ItemShopUiModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchUseCase @Inject constructor(private val productRepository: ProductRepositoryInterface, private val shopRepository: ShopRepositoryInterface){
    fun getDataProducts(device: String, ob: Int, q: String?, rows: Int, source: String, start: Int): Single<List<ProductsItemUiModel>> {
        return this.productRepository.getProductData(device, ob, q, rows, source, start)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun getDataShops(device: String, q: String?, rows: Int, source: String, start: Int): Single<List<ItemShopUiModel>> {
        return this.shopRepository.getShopData(device, q, rows, source, start)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun getProductsAndShops(device: String, ob: Int, q: String?, rows: Int, source: String, start: Int): Single<ProductsAndShopsUiModel> {
        return Single.zip(
                productRepository.getProductData(device, ob, q, rows, source, start),
                shopRepository.getShopData(device, q, rows, source, start),
                BiFunction<List<ProductsItemUiModel>, List<ItemShopUiModel>, ProductsAndShopsUiModel>
                { products, shops -> createProductsAndShopsModel(products, shops)})
    }

    private fun createProductsAndShopsModel(products: List<ProductsItemUiModel>, shops: List<ItemShopUiModel>): ProductsAndShopsUiModel {
        val productsUiModel = products.map { ProductsItemUiModel(it.price, it.imageUrl, it.name) }
        val shopsUiModel = shops.map { ItemShopUiModel(it.shopName, it.shopIcon, it.shopProductsIcon, it.shopReputationIcon, it.shopLocation) }
        return ProductsAndShopsUiModel(productsUiModel, shopsUiModel)
    }
}