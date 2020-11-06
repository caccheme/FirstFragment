package com.example.firstfragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), DetailFragment.FragmentListener {

    private val myFragmentFinishTAG: String = "MainActivity"
    private var mTablet: Boolean = true

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentContainer = findViewById<ViewGroup>(R.id.detail_fragment_container)
        mTablet = fragmentContainer != null

        val tvOut: TextView = findViewById(R.id.textOut)
        tvOut.text = "Fragments side-by-side? $mTablet"

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { viewDetailFragment() }
    }

    private fun viewDetailFragment() {

        val person = Person("Mickey", "Mouse", 35)

        if (mTablet) {
            val fragmentManager = supportFragmentManager
            val fragment = DetailFragment.newInstance(person)
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

    override fun onFragmentFinish(person: Person) {
        Log.i(
            myFragmentFinishTAG, "onFragmentFinish: " +
                    "${person.firstName}, ${person.lastName}, ${person.age}"
        )

        val fragment = supportFragmentManager
            .findFragmentById(R.id.detail_fragment_container) as DetailFragment

        supportFragmentManager
            .beginTransaction()
            .remove(fragment)
            .commit()
    }

}