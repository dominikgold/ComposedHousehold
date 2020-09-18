package com.dominikgold.household.usecases

import com.dominikgold.household.usecases.chores.DefaultLoadChoresUseCase
import com.dominikgold.household.usecases.chores.LoadChoresUseCase
import dagger.Binds
import dagger.Module

@Module
interface UseCasesModule {

    @Binds
    fun bindLoadChoresUseCase(useCase: DefaultLoadChoresUseCase): LoadChoresUseCase

}