package com.example.ba_1963.android_searchproduct_mvp.data.models.shop

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class ResponseShop(

		@field:SerializedName("result")
	val result: ResultShop? = null,

        @field:SerializedName("server_process_time")
	val serverProcessTime: String? = null,

        @field:SerializedName("config")
	val config: Config? = null,

        @field:SerializedName("status")
	val status: String? = null
)