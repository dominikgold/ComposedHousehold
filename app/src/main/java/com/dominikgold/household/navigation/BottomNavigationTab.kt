package com.dominikgold.household.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.VectorAsset
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.res.vectorResource
import com.dominikgold.household.R

enum class BottomNavigationTab {
    HOME,
    CHORES,
}

val BottomNavigationTab.screen: Screen
    get() = when (this) {
        BottomNavigationTab.HOME -> Screen.Home
        BottomNavigationTab.CHORES -> Screen.Chores
    }

@Composable
val BottomNavigationTab.title
        : String
    get() = ContextAmbient.current.getString(
            when (this) {
                BottomNavigationTab.HOME -> R.string.home_tab_title
                BottomNavigationTab.CHORES -> R.string.chores_tab_title
            }
    )

@Composable
val BottomNavigationTab.icon
        : VectorAsset
    get() = vectorResource(
            id = when (this) {
                BottomNavigationTab.HOME -> R.drawable.vec_icon_home
                BottomNavigationTab.CHORES -> R.drawable.vec_icon_chores
            }
    )