package com.dominikgold.household.navigation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

sealed class Screen : Parcelable {

    @Parcelize
    object Home : Screen()

    @Parcelize
    object Chores : Screen()

}
