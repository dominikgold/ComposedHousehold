package com.dominikgold.household.repositories

import com.dominikgold.household.entities.Chore
import com.dominikgold.household.usecases.chores.ChoreRepository
import kotlinx.coroutines.delay
import javax.inject.Inject

class DefaultChoreRepository @Inject constructor() : ChoreRepository {

    override suspend fun getAllChores(): List<Chore> {
        delay(3000)
        return listOf(
                Chore("id1", "Vacuum the house"),
                Chore("id1", "Clean the counter tops"),
                Chore("id1", "Do the laundry"),
        )
    }

}