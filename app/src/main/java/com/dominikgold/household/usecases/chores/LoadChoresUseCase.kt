package com.dominikgold.household.usecases.chores

import com.dominikgold.household.entities.Chore
import javax.inject.Inject

interface LoadChoresUseCase {

    suspend fun loadChores(): List<Chore>

}

class DefaultLoadChoresUseCase @Inject constructor(private val choreRepository: ChoreRepository) : LoadChoresUseCase {

    override suspend fun loadChores() = choreRepository.getAllChores()

}
