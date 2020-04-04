package com.arisupriatna.moviecatalogue.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val title: String,
    val description: String,
    val imagePoster: Int,
    val releaseDate: String
) : Parcelable
