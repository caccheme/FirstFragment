package com.example.firstfragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.david.viewpager.DataProvider

class MainActivity : AppCompatActivity() {
    private val products: List<Product> = DataProvider.productList
    private val numPages = products.size
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}