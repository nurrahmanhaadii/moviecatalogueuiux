package id.haadii.moviecatalogueuiux.movie

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val title: String,
    val release: String,
    val overview: String,
    val genre: String,
    val runtime: String,
    val photo: Int
) : Parcelable