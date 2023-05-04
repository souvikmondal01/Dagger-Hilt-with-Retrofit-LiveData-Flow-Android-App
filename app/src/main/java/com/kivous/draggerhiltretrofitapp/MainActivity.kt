package com.kivous.draggerhiltretrofitapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.kivous.draggerhiltretrofitapp.adapter.PostAdapter
import com.kivous.draggerhiltretrofitapp.databinding.ActivityMainBinding
import com.kivous.draggerhiltretrofitapp.viewmodel.PostViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val postViewModel: PostViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PostAdapter
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        postViewModel.response.observe(this) {
            adapter = PostAdapter(it)
            binding.recyclerView.adapter = adapter
            binding.recyclerView.layoutManager = LinearLayoutManager(this)
            adapter.notifyDataSetChanged()
            Log.d("TAG", it[0].body.toString())
            Log.d("TAG", adapter.itemCount.toString())
        }


    }
}