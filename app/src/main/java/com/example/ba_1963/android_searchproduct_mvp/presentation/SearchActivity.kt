package com.example.ba_1963.android_searchproduct_mvp.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.ba_1963.android_searchproduct_mvp.R
import com.example.ba_1963.android_searchproduct_mvp.presentation.adapter.SearchPagerAdapter
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        viewpager_main.adapter = SearchPagerAdapter(supportFragmentManager)
        tabs_main.setupWithViewPager(viewpager_main)

        val query = intent.getStringExtra("query")
    }
}