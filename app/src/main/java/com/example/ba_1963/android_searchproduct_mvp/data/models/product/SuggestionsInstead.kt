package com.example.ba_1963.android_searchproduct_mvp.data.models.product

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class SuggestionsInstead(

	@field:SerializedName("current_keyword")
	val currentKeyword: String? = null,

	@field:SerializedName("total_data")
	val totalData: Int? = null,

	@field:SerializedName("suggestion_instead")
	val suggestionInstead: String? = null
)