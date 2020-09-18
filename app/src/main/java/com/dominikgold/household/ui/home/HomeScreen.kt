package com.dominikgold.household.ui.home

import androidx.compose.foundation.Box
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.ui.tooling.preview.Preview
import com.dominikgold.household.navigation.BottomNavigationTab
import com.dominikgold.household.navigation.title
import com.dominikgold.household.theming.HouseholdTheme
import com.dominikgold.household.ui.HouseholdTopBar
import com.dominikgold.household.ui.bottomnav.HouseholdBottomNavigation

@Composable
fun HomeScreen(onTabSelected: (BottomNavigationTab) -> Unit) {
    Scaffold(
            topBar = { HouseholdTopBar(title = BottomNavigationTab.HOME.title) },
            bottomBar = { HouseholdBottomNavigation(selectedTab = BottomNavigationTab.HOME, onTabSelected) }
    ) {
        Box(Modifier.fillMaxSize(), gravity = Alignment.Center) {
            Text(text = "Home")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HouseholdTheme() {
        HomeScreen(onTabSelected = {})
    }
}