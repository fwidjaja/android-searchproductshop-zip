package com.example.ba_1963.android_searchproduct_mvp.data.models.shop

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class ResultShop(

	@field:SerializedName("st")
	val st: String? = null,

	@field:SerializedName("search_url")
	val searchUrl: String? = null,

	@field:SerializedName("shops")
	val shops: List<ShopsItem?>? = null,

	@field:SerializedName("paging")
	val paging: Paging? = null,

	@field:SerializedName("source")
	val source: String? = null,

	@field:SerializedName("has_catalog")
	val hasCatalog: Int? = null
)