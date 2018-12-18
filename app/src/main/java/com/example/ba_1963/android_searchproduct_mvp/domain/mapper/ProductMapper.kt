package com.example.ba_1963.android_searchproduct_mvp.domain.mapper

import com.example.ba_1963.android_searchproduct_mvp.data.models.product.Data
import com.example.ba_1963.android_searchproduct_mvp.data.models.product.ProductsItem
import com.example.ba_1963.android_searchproduct_mvp.data.models.product.ResponseProduct
import com.example.ba_1963.android_searchproduct_mvp.presentation.models.product.DataUiModel
import com.example.ba_1963.android_searchproduct_mvp.presentation.models.product.ProductsItemUiModel
import com.example.ba_1963.android_searchproduct_mvp.presentation.models.product.ResponseProductUiModel

object ProductMapper {
    fun responseToUiModel(responseProduct: ResponseProduct): ResponseProductUiModel? {
        responseProduct.data?.let { datas ->
            return dataToUiModel(datas)?.let {
                ResponseProductUiModel(
                        data = it
                )
            }
        } ?: return null
    }

    private fun dataToUiModel(data: Data): DataUiModel? {
        data.products?.let { products ->
            return DataUiModel(
                    products = products.map {
                        productsToUiModel(it)
                    }.filter { it != null }.map { it!! }
            )
        } ?: return null
    }

    private fun productsToUiModel(productsItem: ProductsItem?): ProductsItemUiModel? {
        productsItem?.imageUrl?.let {itemImgUrl ->
            productsItem.name?.let { itemName ->
                productsItem.price?.let { itemPrice ->
                    return ProductsItemUiModel(
                            imageUrl = itemImgUrl,
                            name = itemName,
                            price = itemPrice
                    )
                }
            }
        }  ?: return null
    }
}