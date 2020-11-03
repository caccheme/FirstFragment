package com.example.firstfragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.firstfragment.constants.FRAGMENT_TAG
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

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
        if (mTablet){
            val fragmentManager = supportFragmentManager
            val fragment = DetailActivityFragment()
            fragmentManager
                .beginTransaction()
                .addToBackStack(null)
                .add(R.id.detail_fragment_container, fragment)
                .commit()
        }else{
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }
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