package com.example.newsapp

import android.content.Context
import com.bumptech.glide.Glide
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.databinding.ItemNewsBinding

class Adapter(private val list : List<NewsHeadLines>, private val mycontext : Context, private val onClick:(NewsHeadLines) -> Unit): RecyclerView.Adapter<Adapter.NewsViewHolder>() {



    inner class NewsViewHolder(private val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: NewsHeadLines){
            binding.tvTitle.text = item.title
            binding.tvDes.text = item.description
            binding.tvPublish.text = "Published at ${item.publishedAt}"
            if(item.author != null){
                binding.tvAuthor.text = "Author : ${item.author}"
            }
            Glide.with(mycontext).load(item.urlToImage).into(binding.imgNews)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.onBind(list[position])
        holder.itemView.setOnClickListener{
            onClick(list[position])
        }
    }

    override fun getItemCount() = list.size
}