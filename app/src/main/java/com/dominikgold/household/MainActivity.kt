package com.dominikgold.household

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Providers
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.savedinstancestate.rememberSavedInstanceState
import androidx.compose.ui.platform.setContent
import androidx.ui.tooling.preview.Preview
import com.dominikgold.household.di.ViewModelProvider
import com.dominikgold.household.navigation.NavigationStateContainer
import com.dominikgold.household.navigation.Screen
import com.dominikgold.household.navigation.ViewModelContainerAmbient
import com.dominikgold.household.navigation.screen
import com.dominikgold.household.theming.HouseholdTheme
import com.dominikgold.household.ui.chores.ChoresScreen
import com.dominikgold.household.ui.home.HomeScreen
import javax.inject.Inject

private const val EXTRA_CURRENT_SCREEN = "EXTRA_CURRENT_SCREEN"

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var navigationStateContainer: NavigationStateContainer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (applicationContext as HouseholdApplication).daggerAppComponent.inject(this)
        savedInstanceState?.getParcelable<Screen>(EXTRA_CURRENT_SCREEN)?.let(navigationStateContainer::switchScreen)
        setContent {
            HouseholdTheme {
                Surface(color = MaterialTheme.colors.background) {
                    CurrentScreen(navigationStateContainer = navigationStateContainer)
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putParcelable(EXTRA_CURRENT_SCREEN, navigationStateContainer.currentScreen.value)
    }

}

@Composable
fun CurrentScreen(navigationStateContainer: NavigationStateContainer) {
    Providers(ViewModelContainerAmbient provides navigationStateContainer.viewModelContainer) {
        val screen = navigationStateContainer.currentScreen.collectAsState()
        when (screen.value) {
            Screen.Home -> HomeScreen(onTabSelected = { navigationStateContainer.switchScreen(it.screen) })
            Screen.Chores -> ChoresScreen(onTabSelected = { navigationStateContainer.switchScreen(it.screen) })
        }
    }
}
