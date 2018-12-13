package com.example.ba_1963.android_searchproduct_mvp.domain.mapper

import com.example.ba_1963.android_searchproduct_mvp.data.models.DataItemDataModel
import com.example.ba_1963.android_searchproduct_mvp.data.models.ResultSearchDataModel
import com.example.ba_1963.android_searchproduct_mvp.data.models.ShopDataModel
import com.example.ba_1963.android_searchproduct_mvp.data.models.StatusDataModel
import com.example.ba_1963.android_searchproduct_mvp.presentation.models.DataItemUiModel
import com.example.ba_1963.android_searchproduct_mvp.presentation.models.ItemShopUiModel
import com.example.ba_1963.android_searchproduct_mvp.presentation.models.ResultSearchUiModel
import com.example.ba_1963.android_searchproduct_mvp.presentation.models.StatusUiModel

object SearchMapper {
    fun dataToUiModel(dataItemDataModel: DataItemDataModel) : DataItemUiModel? {
        dataItemDataModel.itemId?.let { itemId ->
            dataItemDataModel.itemName?.let { itemName ->
                dataItemDataModel.itemUri?.let { itemUri ->
                    dataItemDataModel.itemImg?.let { itemImg ->
                        dataItemDataModel.itemPrice?.let { itemPrice ->
                            dataItemDataModel.shop?.let { shop ->
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

    fun resultToUiModel(resultSearchDataModel: ResultSearchDataModel): ResultSearchUiModel? {
        resultSearchDataModel.status?.let { status ->
            resultSearchDataModel.datas?.let { datas ->
                return ResultSearchUiModel(
                        status = statusToUiModel(status),
                        datas = datas.map {
                            dataToUiModel(it)
                        }.filter { it != null }.map { it!! }
                )
            }
        } ?: return null
    }

    fun itemShopToUiModel(itemShopDataModel: ShopDataModel): ItemShopUiModel? {
        itemShopDataModel.id?.let { id ->
            itemShopDataModel.name?.let { name ->
                itemShopDataModel.uri?.let { uri ->
                    itemShopDataModel.isGold?.let { isGold ->
                        itemShopDataModel.rating?.let { rating ->
                            itemShopDataModel.location?.let { location ->
                                itemShopDataModel.reputationImageUri?.let { reputationImageUri ->
                                    itemShopDataModel.shopLucky?.let { shopLucky ->
                                        itemShopDataModel.city?.let { city ->
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

    fun statusToUiModel(statusDataModel: StatusDataModel): StatusUiModel? {
        statusDataModel.errorCode?.let { errorCode ->
            statusDataModel.message?.let { message ->
                return StatusUiModel(
                        errorCode = errorCode,
                        message = message
                )
            }
        } ?: return null
    }
}