package `in`.frostapps.expandableview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Trip(var fromCity: String, var fromState: String, var toCity: String, var toState: String, var imageId: Int, var price: Double) : Parcelable
