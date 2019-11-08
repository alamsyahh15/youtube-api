package com.example.alalmsyah.youtubeapi.ui.main.network

import com.example.alalmsyah.youtubeapi.ui.main.model.ResultYoutube
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object NetworkConfig {

    private fun getInterceptor(): OkHttpClient{
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    private fun getRetrofit() : Retrofit{
        return  Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/youtube/v3/")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun service(): YoutubeService = getRetrofit().create(YoutubeService ::class.java)

}

interface YoutubeService {
    @GET("search?")
    fun getVideo(@Query("part") part : String,
                 @Query("q") q: String,
                 @Query("key") key : String) : Call<ResultYoutube>

}