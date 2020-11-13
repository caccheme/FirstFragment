package com.example.firstfragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fab: FloatingActionButton = findViewById(R.id.fab)

        fab.setOnClickListener { showDialog() }
    }

    private fun showDialog() {

        val p = Person("Mickey", "Mouse", 35)

        val dialog = DataEntryDialog().newInstance(p)
        dialog.show(supportFragmentManager, "DIALOG_FRAGMENT")
    }

}