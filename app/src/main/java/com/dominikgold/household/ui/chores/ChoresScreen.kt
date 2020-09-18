package com.dominikgold.household.ui.chores

import androidx.compose.foundation.Box
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.dominikgold.household.navigation.BottomNavigationTab
import com.dominikgold.household.navigation.title
import com.dominikgold.household.navigation.viewModel
import com.dominikgold.household.theming.HouseholdTheme
import com.dominikgold.household.ui.HouseholdTopBar
import com.dominikgold.household.ui.bottomnav.HouseholdBottomNavigation

@Composable
fun ChoresScreen(onTabSelected: (BottomNavigationTab) -> Unit) {
    Scaffold(
            topBar = { HouseholdTopBar(title = BottomNavigationTab.CHORES.title) },
            bottomBar = { HouseholdBottomNavigation(selectedTab = BottomNavigationTab.CHORES, onTabSelected) }
    ) {
        ChoresContent()
    }
}

@Composable
fun ChoresContent() {
    val viewModel: ChoreListViewModel = viewModel()
    val choreListState by viewModel.state.collectAsState()
    if (choreListState.chores.isNotEmpty()) {
        ChoreList(choreListState.chores, isLoadingMore = choreListState.isLoading)
    } else if (choreListState.isLoading) {
        Box(Modifier.fillMaxSize(), gravity = Alignment.Center) {
            CircularProgressIndicator(Modifier.size(64.dp))
        }
    }
}
