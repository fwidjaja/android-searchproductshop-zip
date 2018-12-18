package com.example.ba_1963.android_searchproduct_mvp.data.models.shop

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Config(

	@field:SerializedName("max_retries")
	val maxRetries: Int? = null,

	@field:SerializedName("backoff_multi")
	val backoffMulti: Int? = null,

	@field:SerializedName("timeout")
	val timeout: Int? = null
)