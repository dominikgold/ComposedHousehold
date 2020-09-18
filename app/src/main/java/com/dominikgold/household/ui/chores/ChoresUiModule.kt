package com.dominikgold.household.ui.chores

import com.dominikgold.household.ViewModel
import com.dominikgold.household.di.ViewModelFactory
import com.dominikgold.household.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ChoresUiModule {

    @Binds
    @IntoMap
    @ViewModelKey(ChoreListViewModel::class)
    abstract fun bindChoreListViewModelFactory(factory: ChoreListViewModelFactory)
            : ViewModelFactory<ViewModel, Any, Any>

}