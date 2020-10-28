package com.example.firstfragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.firstfragment.constants.FRAGMENT_TAG
import com.example.firstfragment.constants.FRAGMENT_TAG2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val tvMessage: TextView = view.findViewById(R.id.message)

    }

    fun addClickHandler(@Suppress("UNUSED_PARAMETER") view: View) {

        val fragment = SimpleFragment().newInstance("Passed to factory method")
        val fragment2: SecondFragment = SecondFragment().newInstance("Second Fragment info")
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .add(R.id.fragment_container, fragment, FRAGMENT_TAG)
            .add(R.id.fragment2_container, fragment2, FRAGMENT_TAG2)
            .commit()
    }

    fun removeClickHandler(@Suppress("UNUSED_PARAMETER") view: View) {
        val fragment: Fragment? = supportFragmentManager
            .findFragmentByTag(FRAGMENT_TAG)
        val fragment2: Fragment? = supportFragmentManager
            .findFragmentByTag(FRAGMENT_TAG2)

        if (fragment != null) {
            if (fragment2 != null) {
                supportFragmentManager
                    .beginTransaction()
                    .remove(fragment)
                    .remove(fragment2)
                    .commit()
            }
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