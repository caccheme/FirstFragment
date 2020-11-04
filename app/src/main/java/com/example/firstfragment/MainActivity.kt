package com.example.firstfragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), DetailFragment.FragmentListener {

    private val myFragmentFinishTAG: String = "MainActivity"
    private var mTablet: Boolean = true

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        this.setSupportActionBar(toolbar)

        val fragmentContainer = findViewById<ViewGroup>(R.id.detail_fragment_container)
        mTablet = fragmentContainer != null

        val tvOut: TextView = findViewById(R.id.textOut)
        tvOut.text = "Fragments side-by-side? $mTablet"

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { viewDetailFragment() }
    }

    private fun viewDetailFragment() {
        if (mTablet) {
            val fragmentManager = supportFragmentManager
            val fragment = DetailFragment()
            fragmentManager
                .beginTransaction()
                .addToBackStack(null)
                .add(R.id.detail_fragment_container, fragment)
                .commit()
        } else {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onFragmentFinish(firstName: String, lastName: String, age: Int) {
        Log.i(myFragmentFinishTAG, "onFragmentFinish: $firstName, $lastName, $age")
    }

}