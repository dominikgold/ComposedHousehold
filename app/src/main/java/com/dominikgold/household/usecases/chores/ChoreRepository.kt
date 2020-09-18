package com.dominikgold.household.usecases.chores

import com.dominikgold.household.entities.Chore

interface ChoreRepository {

    suspend fun getAllChores(): List<Chore>

}