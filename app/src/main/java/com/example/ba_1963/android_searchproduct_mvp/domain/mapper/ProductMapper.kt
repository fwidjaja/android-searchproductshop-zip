package com.example.ba_1963.android_searchproduct_mvp.domain.mapper

import com.example.ba_1963.android_searchproduct_mvp.model.product.Data
import com.example.ba_1963.android_searchproduct_mvp.model.product.ProductsItem
import com.example.ba_1963.android_searchproduct_mvp.model.product.ResponseProduct
import com.example.ba_1963.android_searchproduct_mvp.presentation.uimodels.product.DataUiModel
import com.example.ba_1963.android_searchproduct_mvp.presentation.uimodels.product.ProductsItemUiModel
import com.example.ba_1963.android_searchproduct_mvp.presentation.uimodels.product.ResponseProductUiModel

object ProductMapper {
    fun responseToListUiModel(responseProduct: ResponseProduct): List<ProductsItemUiModel> {
        val list = mutableListOf<ProductsItemUiModel>()
        responseProduct.data.let { data->
            data?.products?.let { products ->
                products.map {
                    productsToUiModel(it)?.let(list::add)
                }
            }
        }
        return list
    }

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