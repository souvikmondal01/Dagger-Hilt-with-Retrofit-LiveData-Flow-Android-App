package com.kivous.draggerhiltretrofitapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kivous.draggerhiltretrofitapp.databinding.ListPostBinding
import com.kivous.draggerhiltretrofitapp.model.Post

class PostAdapter(private val list: ArrayList<Post>) :
    RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    class ViewHolder(val binding: ListPostBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostAdapter.ViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]
        holder.binding.tvBody.text = data.body.toString()
        holder.binding.tvIndex.text = (position + 1).toString() + "."
    }

    override fun getItemCount(): Int {
        return list.size
    }

}