package com.dominikgold.household.ui.chores

import androidx.compose.foundation.Box
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumnForIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.dominikgold.household.theming.HouseholdTheme

@Composable
fun ChoreList(chores: List<ChoreUiModel>, isLoadingMore: Boolean) {
    val padding = PaddingValues(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
    LazyColumnForIndexed(
            items = chores,
            contentPadding = padding,
            horizontalAlignment = Alignment.CenterHorizontally
    ) { index, chore ->
        ChoreListItem(chore = chore)
        if (isLoadingMore && index == chores.lastIndex) {
            Spacer(modifier = Modifier.height(8.dp))
            CircularProgressIndicator(Modifier.size(32.dp))
        }
    }
}

@Composable
fun ChoreListItem(chore: ChoreUiModel) {
    Box(Modifier.padding(vertical = 8.dp).fillMaxWidth()) {
        Text(text = chore.title)
    }
}

@Preview(showBackground = true)
@Composable
fun ChoreListPreview() {
    HouseholdTheme() {
        ChoreList(chores = listOf(
                ChoreUiModel("id", "vacuum the house"),
                ChoreUiModel("id", "dust the counter tops"),
                ChoreUiModel("id", "do the laundry"),
        ), isLoadingMore = false)
    }
}

@Preview(showBackground = true)
@Composable
fun ChoreListLoadingMorePreview() {
    HouseholdTheme() {
        ChoreList(chores = listOf(
                ChoreUiModel("id", "vacuum the house"),
                ChoreUiModel("id", "dust the counter tops"),
                ChoreUiModel("id", "do the laundry"),
        ), isLoadingMore = true)
    }
}
