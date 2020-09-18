package com.dominikgold.household.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticAmbientOf
import com.dominikgold.household.ViewModel
import com.dominikgold.household.ViewModelTag
import com.dominikgold.household.di.ViewModelProvider
import javax.inject.Inject
import kotlin.reflect.KClass

class ViewModelContainer @Inject constructor(private val viewModelProvider: ViewModelProvider) {

    private val viewModels = mutableMapOf<ViewModelTag, ViewModel>()

    @Suppress("UNCHECKED_CAST")
    fun <VM : ViewModel, SavedState, Parameters> get(viewModelClass: KClass<VM>, savedState: SavedState?, parameters: Parameters?): VM {
        val tag = ViewModelTag(viewModelClass, parameters)
        val viewModel = viewModels.getOrPut(tag) { viewModelProvider.provide(viewModelClass, savedState, parameters) }
        return viewModel as VM
    }

    fun release() {
        viewModels.values.forEach { it.release() }
        viewModels.clear()
    }

}

@Composable
inline fun <reified VM : ViewModel, SavedState, Parameters> viewModel(savedState: SavedState?, parameters: Parameters?) =
        ViewModelContainerAmbient.current.get(VM::class, savedState, parameters)

@Composable
inline fun <reified VM : ViewModel, SavedState> viewModel(savedState: SavedState?) =
        ViewModelContainerAmbient.current.get(VM::class, savedState, null)

@Composable
inline fun <reified VM : ViewModel> viewModel() =
        ViewModelContainerAmbient.current.get(VM::class, null, null)

val ViewModelContainerAmbient = staticAmbientOf<ViewModelContainer> {
    throw IllegalStateException("No ViewModelContainer provided")
}
