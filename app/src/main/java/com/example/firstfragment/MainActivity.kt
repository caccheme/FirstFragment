package com.example.firstfragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

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

        fab.setOnClickListener { showDialog() }
    }

    private fun showDialog() {
        val dialogFragment = AlertDialogFragment()
        dialogFragment.isCancelable = false
        dialogFragment.show(supportFragmentManager, "DIALOG_FRAGMENT")
    }

}