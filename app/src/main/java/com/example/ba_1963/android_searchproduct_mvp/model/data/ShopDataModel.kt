package com.example.ba_1963.android_searchproduct_mvp.model.data

import com.example.ba_1963.android_searchproduct_mvp.model.ui.ItemShopUiModel
import com.google.gson.annotations.SerializedName

data class ShopDataModel (@SerializedName("itemId") val id: Long? = 0L,
                     @SerializedName("itemName") val name: String? = "",
                     @SerializedName("itemUri") val uri: String? = "",
                     @SerializedName("is_gold") val isGold: Int? = 0,
                     @SerializedName("rating") val rating: Int? = 0,
                     @SerializedName("location") val location: String? = "",
                     @SerializedName("reputation_image_uri") val reputationImageUri: String? = "",
                     @SerializedName("shop_lucky") val shopLucky: String? = "",
                     @SerializedName("city") val city: String? = ""
) {
    fun toUiModel(): ItemShopUiModel? {
        id?.let { id ->
            name?.let { name ->
                uri?.let { uri ->
                    isGold?.let { isGold ->
                        rating?.let { rating ->
                            location?.let { location ->
                                reputationImageUri?.let { reputationImageUri ->
                                    shopLucky?.let { shopLucky ->
                                        city?.let { city ->
                                            return ItemShopUiModel(
                                                    id = id,
                                                    name = name,
                                                    uri = uri,
                                                    isGold = isGold,
                                                    rating = rating,
                                                    location = location,
                                                    reputationImgUri = reputationImageUri,
                                                    shopLucky = shopLucky,
                                                    city = city
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } ?: return null
    }
}