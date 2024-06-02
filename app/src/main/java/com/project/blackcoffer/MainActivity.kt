package com.project.blackcoffer


import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.blackcoffer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var arrayList : ArrayList<ItemsInfo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //check internet state

        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        if (networkInfo == null || !networkInfo.isConnectedOrConnecting) {
            Toast.makeText(this, "No Internet Connection", Toast.LENGTH_LONG).show()
        }
        //sample Items Data ->

        val arrayList = ArrayList<ItemsInfo>()
        arrayList.addAll(
            listOf(
                ItemsInfo("Instagram", R.drawable.instagram, "https://www.instagram.com"),
                ItemsInfo("Facebook", R.drawable.facebook, "https://www.facebook.com"),
                ItemsInfo("X", R.drawable.twitter, "https://www.twitter.com"),
                ItemsInfo("LinkedIn", R.drawable.linkedin, "https://www.linkedin.com"),
                ItemsInfo("Youtube", R.drawable.youtube, "https://www.youtube.com"),
                ItemsInfo("Facebook", R.drawable.facebook, "https://www.facebook.com"),
                ItemsInfo("X", R.drawable.twitter, "https://www.twitter.com"),
                ItemsInfo("LinkedIn", R.drawable.linkedin, "https://www.linkedin.com"),
                ItemsInfo("Youtube", R.drawable.youtube, "https://www.youtube.com"),
                ItemsInfo("Youtube", R.drawable.youtube, "https://www.youtube.com"),
                ItemsInfo("Facebook", R.drawable.facebook, "https://www.facebook.com"),
                ItemsInfo("X", R.drawable.twitter, "https://www.twitter.com"),
                ItemsInfo("LinkedIn", R.drawable.linkedin, "https://www.linkedin.com"),
            )
        )

        //appLogo recycler View
        binding.myRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.myRecyclerView.adapter = NewAdapter(arrayList, this)
        //appCards Recycler view
        binding.myRecyclerViewCard1.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.myRecyclerViewCard1.adapter = CardAdapter(arrayList, this)

        binding.myRecyclerViewCard2.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.myRecyclerViewCard2.adapter = CardAdapter(arrayList, this)

        //grid recycler view
        binding.myRecyclerViewCard4.layoutManager = GridLayoutManager(this, 2)
        binding.myRecyclerViewCard4.adapter = CardAdapter(arrayList, this)

    }
}