package com.dominikgold.household.ui.chores

import android.os.Parcelable
import com.dominikgold.household.entities.Chore
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ChoreListUiModel(
        val chores: List<ChoreUiModel>,
        val isLoading: Boolean
) : Parcelable

@Parcelize
data class ChoreUiModel(val id: String, val title: String) : Parcelable

fun List<Chore>.toUiModels() = map { ChoreUiModel(it.id, it.title) }
