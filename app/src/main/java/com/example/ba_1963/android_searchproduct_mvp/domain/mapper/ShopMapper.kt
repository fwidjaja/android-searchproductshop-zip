package com.example.ba_1963.android_searchproduct_mvp.domain.mapper

import com.example.ba_1963.android_searchproduct_mvp.data.models.shop.ResponseShop
import com.example.ba_1963.android_searchproduct_mvp.data.models.shop.ResultShop
import com.example.ba_1963.android_searchproduct_mvp.data.models.shop.ShopsItem
import com.example.ba_1963.android_searchproduct_mvp.presentation.models.shop.ItemShopUiModel
import com.example.ba_1963.android_searchproduct_mvp.presentation.models.shop.ResponseShopUiModel
import com.example.ba_1963.android_searchproduct_mvp.presentation.models.shop.ResultShopUiModel

object ShopMapper {
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