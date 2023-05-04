package com.kivous.draggerhiltretrofitapp.network

import com.kivous.draggerhiltretrofitapp.model.Post
import javax.inject.Inject

class PostServiceImp @Inject constructor(private val postApiService: PostApiService) {

    suspend fun getPost(): ArrayList<Post> = postApiService.getPost()
}