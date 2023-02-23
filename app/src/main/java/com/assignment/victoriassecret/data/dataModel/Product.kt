package com.assignment.victoriassecret.data.dataModel

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val brand: String,
    val id: String,
    val name: String,
    val offerPrice: String,
    val price: String,
    val productDesc: String,
    val productUrl: String
) : Parcelable