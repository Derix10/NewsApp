package com.example.newsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.newsapp.databinding.FragmentFirstBinding
import com.example.newsapp.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private lateinit var newsTitle: String
    private lateinit var newsDes: String
    private lateinit var newsContent: String
    private lateinit var newsImg: String
    private lateinit var newsAuthor: String
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newsTitle = arguments?.getString(FirstFragment.KEY_TITLE).toString()
        newsDes = arguments?.getString(FirstFragment.KEY_DES).toString()
        newsContent = arguments?.getString(FirstFragment.KEY_CONTENT).toString()
        newsImg = arguments?.getString(FirstFragment.KEY_IMG).toString()
        newsAuthor = arguments?.getString(FirstFragment.KEY_AUTHOR).toString()
        binding.secTitle.text = newsTitle

        binding.secDes.text = newsDes
        binding.tvContent.text = newsContent
        if (newsAuthor != null) {
            binding.tvAuthor.text = "Author: $newsAuthor"
        }
        Glide.with(requireActivity()).load(newsImg).into(binding.secImg)
    }
}