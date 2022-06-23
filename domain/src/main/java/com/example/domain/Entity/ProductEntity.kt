package com.example.domain.Entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductEntity(
    var typeAccount : String,
    var mountAccount : String,
    var numberAccount : String
) : Parcelable