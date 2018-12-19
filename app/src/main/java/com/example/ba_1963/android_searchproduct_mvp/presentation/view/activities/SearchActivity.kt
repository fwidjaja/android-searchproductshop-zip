package com.example.ba_1963.android_searchproduct_mvp.presentation.view.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.example.ba_1963.android_searchproduct_mvp.R
import com.example.ba_1963.android_searchproduct_mvp.presentation.view.adapters.SearchPagerAdapter
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.toolbar_search.*

class SearchActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        setSupportActionBar(toolbarSearch)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        viewpager_search.adapter = SearchPagerAdapter(supportFragmentManager)
        tabs_main.setupWithViewPager(viewpager_search)

        val query = intent.getStringExtra("query")
        labelQuery.text = query
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}