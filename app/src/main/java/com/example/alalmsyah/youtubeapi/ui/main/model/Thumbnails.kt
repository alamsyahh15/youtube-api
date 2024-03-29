package com.example.alalmsyah.youtubeapi.ui.main.model

import com.google.gson.annotations.SerializedName

data class Thumbnails(

	@field:SerializedName("default")
	val jsonMemberDefault: JsonMemberDefault? = null,

	@field:SerializedName("high")
	val high: High? = null,

	@field:SerializedName("medium")
	val medium: Medium? = null
)