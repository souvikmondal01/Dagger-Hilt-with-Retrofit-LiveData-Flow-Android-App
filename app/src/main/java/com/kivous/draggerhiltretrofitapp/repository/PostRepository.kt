package com.kivous.draggerhiltretrofitapp.repository

import com.kivous.draggerhiltretrofitapp.model.Post
import com.kivous.draggerhiltretrofitapp.network.PostServiceImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PostRepository
@Inject
constructor(private val postServiceImp: PostServiceImp) {

    fun getPost(): Flow<ArrayList<Post>> = flow {
        val response = postServiceImp.getPost()
        emit(response)
    }.flowOn(Dispatchers.IO)
}