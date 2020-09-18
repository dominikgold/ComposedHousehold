package com.dominikgold.household.di

import com.dominikgold.household.navigation.DefaultNavigationStateContainer
import com.dominikgold.household.navigation.NavigationStateContainer
import dagger.Binds
import dagger.Module

@Module
interface NavigationModule {

    @Binds
    fun bindNavigationStateContainer(navigationStateContainer: DefaultNavigationStateContainer): NavigationStateContainer

}