package com.example.testgustavointerbank.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductModel(
    var typeAccount : String,
    var mountAccount : String,
    var numberAccount : String
) : Parcelable