package com.example.firstfragment

import android.app.Activity
import android.util.DisplayMetrics

@Suppress("DEPRECATION")
class ScreenUtility(activity: Activity) {
    var dpWidth: Float
    var dpHeight: Float

    init {
        val display = activity.windowManager.defaultDisplay
        val outMetrics = DisplayMetrics()
        display.getMetrics(outMetrics)
        val density = activity.resources.displayMetrics.density
        dpWidth = outMetrics.widthPixels / density
        dpHeight = outMetrics.heightPixels / density
    }
}