package com.dominikgold.household.ui.bottomnav

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.runtime.Composable
import androidx.ui.tooling.preview.Preview
import com.dominikgold.household.navigation.BottomNavigationTab
import com.dominikgold.household.navigation.icon
import com.dominikgold.household.navigation.title

@Composable
fun HouseholdBottomNavigation(
        selectedTab: BottomNavigationTab,
        onTabSelected: (BottomNavigationTab) -> Unit
) {
    BottomNavigation() {
        BottomNavigationTab.values().forEach { tab ->
            BottomNavigationItem(
                    icon = { Icon(asset = tab.icon) },
                    label = { Text(tab.title) },
                    selected = tab == selectedTab,
                    onClick = { onTabSelected(tab) }
            )
        }
    }
}

@Preview
@Composable
fun BottomNavigationPreview() {
    HouseholdBottomNavigation(selectedTab = BottomNavigationTab.HOME, onTabSelected = {})
}
