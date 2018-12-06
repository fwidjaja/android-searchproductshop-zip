package com.example.ba_1963.android_searchproduct_mvp.model.data

import com.example.ba_1963.android_searchproduct_mvp.model.ui.DataItemUiModel
import com.google.gson.annotations.SerializedName

data class DataItemDataModel (@SerializedName("id") val itemId: Long? = 0L,
                              @SerializedName("name") val itemName: String? = "",
                              @SerializedName("uri") val itemUri: String? = "",
                              @SerializedName("image_uri") val itemImg: String? = "",
                              @SerializedName("price") val itemPrice: String? = "",
                              @SerializedName("shop") val shop: ShopDataModel?
) {
    fun toUiModel() : DataItemUiModel? {
        itemId?.let { itemId ->
            itemName?.let { itemName ->
                itemUri?.let { itemUri ->
                    itemImg?.let { itemImg ->
                        itemPrice?.let { itemPrice ->
                            shop?.let { shop ->
                                return DataItemUiModel(
                                    itemId = itemId,
                                        itemName = itemName,
                                        itemUri = itemUri,
                                        itemImg = itemImg,
                                        itemPrice = itemPrice,
                                        itemShop = shop
                                )
                            }
                        }
                    }
                }
            }
        } ?: return null
    }
}