package com.example.alalmsyah.youtubeapi.ui.main.model

import com.google.gson.annotations.SerializedName

data class Id(

	@field:SerializedName("kind")
	val kind: String? = null,

	@field:SerializedName("videoId")
	val videoId: String? = null
)