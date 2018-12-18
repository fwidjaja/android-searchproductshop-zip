package com.example.ba_1963.android_searchproduct_mvp.data.models.shop

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class ShopsItem(

	@field:SerializedName("shop_rate_accuracy")
	val shopRateAccuracy: Int? = null,

	@field:SerializedName("shop_status")
	val shopStatus: Int? = null,

	@field:SerializedName("shop_rate_service")
	val shopRateService: Int? = null,

	@field:SerializedName("shop_rate_speed")
	val shopRateSpeed: Int? = null,

	@field:SerializedName("shop_domain")
	val shopDomain: String? = null,

	@field:SerializedName("shop_is_owner")
	val shopIsOwner: Int? = null,

	@field:SerializedName("shop_total_transaction")
	val shopTotalTransaction: String? = null,

	@field:SerializedName("shop_total_favorite")
	val shopTotalFavorite: String? = null,

	@field:SerializedName("shop_name")
	val shopName: String? = null,

	@field:SerializedName("shop_image")
	val shopImage: String? = null,

	@field:SerializedName("shop_tag_line")
	val shopTagLine: String? = null,

	@field:SerializedName("product_images")
	val productImages: List<String?>? = null,

	@field:SerializedName("reputation_image_uri")
	val reputationImageUri: String? = null,

	@field:SerializedName("shop_id")
	val shopId: Int? = null,

	@field:SerializedName("reputation_score")
	val reputationScore: Int? = null,

	@field:SerializedName("is_official")
	val isOfficial: Boolean? = null,

	@field:SerializedName("shop_lucky")
	val shopLucky: String? = null,

	@field:SerializedName("shop_url")
	val shopUrl: String? = null,

	@field:SerializedName("shop_is_img")
	val shopIsImg: Int? = null,

	@field:SerializedName("shop_image_300")
	val shopImage300: String? = null,

	@field:SerializedName("shop_location")
	val shopLocation: String? = null,

	@field:SerializedName("shop_description")
	val shopDescription: String? = null,

	@field:SerializedName("ga_key")
	val gaKey: String? = null,

	@field:SerializedName("shop_gold_shop")
	val shopGoldShop: Int? = null
)