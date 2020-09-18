package com.dominikgold.household.repositories

import com.dominikgold.household.usecases.chores.ChoreRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoriesModule {

    @Binds
    fun bindChoreRepository(repository: DefaultChoreRepository): ChoreRepository

}