package id.haadii.moviecatalogueuiux.tv_show

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Tv(
    val title: String,
    val release: String,
    val overview: String,
    val genre: String,
    val runtime: String,
    val photo: Int
) : Parcelable