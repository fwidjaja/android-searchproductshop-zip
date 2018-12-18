package com.example.ba_1963.android_searchproduct_mvp.data.models.product

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Data(

	@field:SerializedName("q")
	val Q: String? = null,

	@field:SerializedName("suggestions_instead")
	val suggestionsInstead: SuggestionsInstead? = null,

	@field:SerializedName("related")
	val related: Related? = null,

	@field:SerializedName("share_url")
	val shareUrl: String? = null,

	@field:SerializedName("suggestion_text")
	val suggestionText: SuggestionText? = null,

	@field:SerializedName("catalogs")
	val catalogs: List<CatalogsItem?>? = null,

	@field:SerializedName("suggestions")
	val suggestions: Suggestions? = null,

	@field:SerializedName("source")
	val source: String? = null,

	@field:SerializedName("is_filter")
	val isFilter: Boolean? = null,

	@field:SerializedName("redirection")
	val redirection: Redirection? = null,

	@field:SerializedName("products")
	val products: List<ProductsItem?>? = null
)