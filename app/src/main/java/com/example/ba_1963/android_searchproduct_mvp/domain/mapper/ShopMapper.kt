package com.example.ba_1963.android_searchproduct_mvp.domain.mapper

import com.example.ba_1963.android_searchproduct_mvp.model.shop.ResponseShop
import com.example.ba_1963.android_searchproduct_mvp.model.shop.ResultShop
import com.example.ba_1963.android_searchproduct_mvp.model.shop.ShopsItem
import com.example.ba_1963.android_searchproduct_mvp.presentation.uimodels.shop.ItemShopUiModel
import com.example.ba_1963.android_searchproduct_mvp.presentation.uimodels.shop.ResponseShopUiModel
import com.example.ba_1963.android_searchproduct_mvp.presentation.uimodels.shop.ResultShopUiModel

object ShopMapper {
    fun responseToListUiModel(responseShop: ResponseShop): List<ItemShopUiModel> {
        val list = mutableListOf<ItemShopUiModel>()
        responseShop.result.let { result->
            result?.shops .let { shops ->
                shops?.map {
                    ShopMapper.shopsToUiModel(it)?.let(list::add)
                }
            }
        }
        return list
    }

    fun responseToUiModel(responseShop: ResponseShop): ResponseShopUiModel? {
        responseShop.status?.let { status ->
            responseShop.result?.let { results ->
                return resultToUiModel(results)?.let {
                    ResponseShopUiModel(
                            status = status,
                            result = it
                    )
                }
            }
        } ?: return null
    }

    private fun resultToUiModel(result: ResultShop) : ResultShopUiModel? {
        result.shops?.let { shops ->
            return ResultShopUiModel(
                    shops = shops.map {
                        shopsToUiModel(it)
                    }.filter { it != null }.map { it!! }
            )
        } ?: return null
    }

    private fun shopsToUiModel(shopsItem: ShopsItem?): ItemShopUiModel? {
        shopsItem?.shopName?.let { shopName ->
            shopsItem.shopImage?.let { shopImage ->
                shopsItem.productImages?.let { productImages ->
                    shopsItem.reputationImageUri?.let { reputationImgUri ->
                        shopsItem.shopLocation?.let { shopLocation ->
                            return ItemShopUiModel(
                                    shopName = shopName,
                                    shopIcon = shopImage,
                                    shopProductsIcon = productImages.filterNotNull(),
                                    shopReputationIcon = reputationImgUri,
                                    shopLocation = shopLocation
                            )
                        }
                    }
                }
            }
        } ?: return null
    }
}