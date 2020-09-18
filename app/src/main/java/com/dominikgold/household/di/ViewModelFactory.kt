package com.dominikgold.household.di

import com.dominikgold.household.ViewModel

interface ViewModelFactory<VM : ViewModel, SavedState, Parameters> {

    fun create(savedState: SavedState?, parameters: Parameters?): VM

}