package com.example.firstfragment

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Product(
    val productId: String,
    val name: String,
    private val description: String,
    val price: Double) : Parcelable {

    fun getDescription(): String {
        return """
               $description
               """.trimIndent()
    }

}