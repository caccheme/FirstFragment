package com.example.firstfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View


class MainActivity : AppCompatActivity() {

    private val fragment: SimpleFragment = SimpleFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clickHandler(@Suppress("UNUSED_PARAMETER")view: View) {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.simple_fragment, fragment)
            .commit()
    }
}