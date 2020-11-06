package com.example.firstfragment

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Suppress("unused")
@Parcelize
class Person(var firstName: String?, var lastName: String?, var age: Int) : Parcelable
