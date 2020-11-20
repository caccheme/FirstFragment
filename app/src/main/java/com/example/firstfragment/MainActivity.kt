package com.example.firstfragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.david.viewpager.DataProvider

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private lateinit var mPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPager = findViewById(R.id.pager)
        val pagerAdapter = ViewPagerAdapter(supportFragmentManager)
        mPager.adapter = pagerAdapter
    }

    private class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
        private val products: List<Product> = DataProvider.productList
        private val numPages = products.size

        override fun getCount(): Int {
            return numPages
        }

        override fun getItem(position: Int): Fragment {
            return ItemFragment.newInstance(products[position])
        }

    }

    override fun onBackPressed() {
        if (mPager.currentItem == 0) {
            super.onBackPressed()
        } else {
            mPager.currentItem = mPager.currentItem -1
        }
    }

}