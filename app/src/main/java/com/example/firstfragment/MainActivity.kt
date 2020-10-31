package com.example.firstfragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.firstfragment.constants.FRAGMENT_TAG
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        this.setSupportActionBar(toolbar)

        val fragmentContainer = findViewById<ViewGroup>(R.id.detail_fragment_container)
        val mTablet: Boolean = (fragmentContainer != null)

        val tvOut: TextView = findViewById(R.id.textOut)
        tvOut.text = "Fragments side-by-side? $mTablet"
    }

    fun addClickHandler(@Suppress("UNUSED_PARAMETER") view: View) {

        val fragment = AppearingFragment().newInstance("Passed to factory method")
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .add(R.id.appearing_fragment_container, fragment, FRAGMENT_TAG)
            .commit()
    }

    fun removeClickHandler(@Suppress("UNUSED_PARAMETER") view: View) {
        val fragment: Fragment? = supportFragmentManager
            .findFragmentByTag(FRAGMENT_TAG)

        if (fragment != null) {
                supportFragmentManager
                    .beginTransaction()
                    .remove(fragment)
                    .commit()
        }
    }

    fun onMeasureBtnClick(@Suppress("UNUSED_PARAMETER") view: View) {
        val su = ScreenUtility(this)
        mOut.text = String.format("width: ${su.dpWidth}, Height: ${su.dpHeight}")

        val mUseFragment: Boolean
        mUseFragment = su.dpWidth >= 820
        Toast.makeText(
            this,
            "using fragment: $mUseFragment",
            Toast.LENGTH_SHORT
        ).show()
    }

}