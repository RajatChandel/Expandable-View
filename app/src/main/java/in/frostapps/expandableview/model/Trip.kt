package `in`.frostapps.expandableview.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Trip(val fromCity: String, val fromState: String, val toCity: String, val toState: String, val imageId: Int, val price: Double) : Parcelable
