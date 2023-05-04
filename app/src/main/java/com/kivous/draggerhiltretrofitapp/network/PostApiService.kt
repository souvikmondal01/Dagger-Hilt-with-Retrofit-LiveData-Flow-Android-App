package com.kivous.draggerhiltretrofitapp.network

import com.kivous.draggerhiltretrofitapp.model.Post
import retrofit2.http.GET

interface PostApiService {

    @GET("posts")
    suspend fun getPost(): ArrayList<Post>
}