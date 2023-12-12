package com.dicoding.beescape.api.response

import com.google.gson.annotations.SerializedName

data class SignUpResponse(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("token")
	val token: String? = null
)
