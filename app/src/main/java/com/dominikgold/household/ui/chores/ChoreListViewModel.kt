package com.dominikgold.household.ui.chores

import com.dominikgold.household.ViewModel
import com.dominikgold.household.di.ViewModelFactory
import com.dominikgold.household.usecases.chores.LoadChoresUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class ChoreListViewModel(private val loadChoresUseCase: LoadChoresUseCase, savedChoreList: List<ChoreUiModel>?) : ViewModel() {

    private val _state = MutableStateFlow(ChoreListUiModel(
            chores = savedChoreList ?: listOf(),
            isLoading = savedChoreList == null
    ))

    val state: StateFlow<ChoreListUiModel>
        get() = _state

    init {
        if (savedChoreList == null) {
            coroutineScope.launch {
                _state.value = _state.value.copy(isLoading = true)
                val chores = loadChoresUseCase.loadChores()
                _state.value = ChoreListUiModel(chores.toUiModels(), isLoading = false)
            }
        }
    }

}

class ChoreListViewModelFactory @Inject constructor(private val loadChoresUseCase: LoadChoresUseCase)
    : ViewModelFactory<ChoreListViewModel, List<ChoreUiModel>, Nothing> {

    override fun create(savedState: List<ChoreUiModel>?, parameters: Nothing?): ChoreListViewModel {
        return ChoreListViewModel(loadChoresUseCase, savedChoreList = savedState)
    }

}
