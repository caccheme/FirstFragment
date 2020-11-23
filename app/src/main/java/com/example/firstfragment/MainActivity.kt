package com.example.firstfragment

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    fun onSettingsClick(item: MenuItem) {
        val intent = Intent(this, MyPreferencesActivity::class.java)
        startActivity(intent)
    }

    fun onTestPrefClick(item: MenuItem) {
        val preferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val userName: String? = preferences.getString("username", "not defined")
        Toast.makeText(this, "User Name: $userName", Toast.LENGTH_SHORT).show()
    }

}