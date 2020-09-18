package com.dominikgold.household.di

import android.content.Context
import com.dominikgold.household.MainActivity
import com.dominikgold.household.repositories.RepositoriesModule
import com.dominikgold.household.ui.chores.ChoresUiModule
import com.dominikgold.household.usecases.UseCasesModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    UseCasesModule::class,

    NavigationModule::class,
    RepositoriesModule::class,

    ChoresUiModule::class,
])
interface AppComponent {

    @Component.Builder
    interface Builder {

        fun build(): AppComponent

        @BindsInstance
        fun application(@ApplicationContext context: Context): Builder

    }

    fun inject(activity: MainActivity)

}