package com.example.firstfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.firstfragment.constants.FRAGMENT_TAG

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun addClickHandler(@Suppress("UNUSED_PARAMETER")view: View) {

        val arguments = Bundle()
        arguments.putString(SimpleFragment.MESSAGE_KEY, "Passed as an argument")

        val fragment = SimpleFragment()
        fragment.arguments = arguments
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .add(R.id.fragment_container, fragment, FRAGMENT_TAG)
            .commit()
    }

    fun removeClickHandler(@Suppress("UNUSED_PARAMETER")view: View) {
        val fragment: Fragment? = supportFragmentManager
            .findFragmentByTag(FRAGMENT_TAG)

        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .remove(fragment)
                .commit()
        }
    }
}