package com.kivous.draggerhiltretrofitapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.kivous.draggerhiltretrofitapp.model.Post
import com.kivous.draggerhiltretrofitapp.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import javax.inject.Inject

@HiltViewModel
class PostViewModel
@Inject
constructor(private val postRepository: PostRepository) : ViewModel() {

    val response: LiveData<ArrayList<Post>> = postRepository.getPost().catch {
        Log.d("TAG", "${it.message}")
    }.asLiveData()

}