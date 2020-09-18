package com.dominikgold.household.ui

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.VectorAsset
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.dominikgold.household.R
import com.dominikgold.household.theming.HouseholdTheme

@Composable
fun HouseholdTopBar(title: String, navigationIcon: VectorAsset? = null, onNavigationIconClicked: () -> Unit = {}) {
    TopAppBar(
            title = { Text(text = title) },
            navigationIcon = navigationIcon?.let { navIcon ->
                { NavigationIcon(icon = navIcon, onClick = onNavigationIconClicked) }
            }
    )
}

@Composable
fun NavigationIcon(icon: VectorAsset, onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(asset = icon)
    }
}

@Preview
@Composable
fun TopBarPreview() {
    HouseholdTheme {
        Column {
            HouseholdTopBar(title = "Chores")
            Spacer(Modifier.height(32.dp))
            HouseholdTopBar(title = "Chores", navigationIcon = vectorResource(id = R.drawable.vec_icon_chores))
        }
    }
}
