package com.example.firstfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firstfragment.R.id.simple_fragment
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = SimpleFragment()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.simple_fragment, fragment)
            .commit()
    }
}