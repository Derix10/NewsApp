package com.example.newsapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.newsapp.databinding.ActivityMainBinding
import com.example.newsapp.databinding.FragmentFirstBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private var adapter: Adapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNews.setOnClickListener{
            getNews()
        }
    }

    fun getNews(){
        App.api.getNews(null, null, binding.edNews.text.toString(), "3ef2416646ef4069a845612471ec2a47").enqueue(
            object : Callback<NewsApiResponse> {
                override fun onResponse(
                    call: Call<NewsApiResponse>,
                    response: Response<NewsApiResponse>
                ) {
                    showList(response.body()?.articles)
                }

                override fun onFailure(call: Call<NewsApiResponse>, t: Throwable) {

                    Log.e("ololo", "Error: ${t.message}")
                }

            }
        )

    }

    private fun showList(articles: List<NewsHeadLines>?) {
        adapter = Adapter(articles!!, requireContext(), this::onClick)
        binding.rvNews.adapter = adapter
    }
    fun onClick(news: NewsHeadLines){
        val bundle = Bundle()
        bundle.putString(KEY_TITLE, news.title)
        bundle.putString(KEY_DES, news.description)
        bundle.putString(KEY_CONTENT, news.content)
        bundle.putString(KEY_IMG, news.urlToImage)
        bundle.putString(KEY_AUTHOR, news.author)
        findNavController().navigate(R.id.secondFragment, bundle)
    }
    companion object{
        const val KEY_TITLE = "key.title"
        const val KEY_DES = "key.des"
        const val KEY_CONTENT = "key.content"
        const val KEY_IMG = "key.img"
        const val KEY_AUTHOR = "key.author"

    }}
