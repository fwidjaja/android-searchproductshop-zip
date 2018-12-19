package com.example.ba_1963.android_searchproduct_mvp.model.product

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Related(

	@field:SerializedName("related_keyword")
	val relatedKeyword: String? = null,

	@field:SerializedName("other_related")
	val otherRelated: List<Any?>? = null
)