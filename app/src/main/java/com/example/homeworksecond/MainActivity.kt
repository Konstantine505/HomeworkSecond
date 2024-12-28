package com.example.homeworksecond

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homeworksecond.adapters.ProductsAdapter
import com.example.homeworksecond.adapters.SongsAdapter
import com.example.homeworksecond.databinding.ActivityMainBinding
import com.example.homeworksecond.model.ProductUI
import com.example.homeworksecond.model.SongUI
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var productsAdapter: ProductsAdapter
    private lateinit var songsAdapter: SongsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpPager()
        setUpRecycler()
    }

    private fun setUpPager() {
        with(binding) {
            productsAdapter = ProductsAdapter()
            pager.adapter = productsAdapter
            productsAdapter.submitList(getPagerData())
            TabLayoutMediator(tabLayout, pager) { _, _ ->
            }.attach()
        }
    }

    private fun setUpRecycler() {
        with(binding) {
            songsAdapter = SongsAdapter()
            recycler.adapter = songsAdapter
            songsAdapter.submitList(getRecyclerData())

        }
    }

    private fun getPagerData() = listOf(
        ProductUI(
            id = 1,
            price = "$200",
            title = "Dope coat",
            favorite = false,
            imageRes = R.drawable.prod1
        ),
        ProductUI(
            id = 2,
            price = "$150",
            title = "Coolet Blaze",
            favorite = false,
            imageRes = R.drawable.prod2
        ),
        ProductUI(
            id = 3,
            price = "$40",
            title = "Anfor chol",
            favorite = true,
            imageRes = R.drawable.prod3
        ),
        ProductUI(
            id = 4,
            price = "$370",
            title = "Expe pro",
            favorite = false,
            imageRes = R.drawable.prod4
        )
    )

    private fun getRecyclerData() = listOf(
        SongUI(
            id = 1,
            cover = R.drawable.song4,
            name = "505"
        ),
        SongUI(
            id = 2,
            cover = R.drawable.song2,
            name = "Afternoon's hat "
        ), SongUI(
            id = 3,
            cover = R.drawable.song1,
            name = "Snap out of it "
        ),
        SongUI(
            id = 4,
            cover = R.drawable.song1,
            name = "I wanna be yours"
        ),
        SongUI(
            id = 5,
            cover = R.drawable.song3,
            name = "The view from the afternoon"
        )
    )
}
