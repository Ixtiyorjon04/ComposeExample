package uz.gita.composeexample.test

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow


interface TestViewModel {
    val uiState: StateFlow<UIState?>

    fun onEventDispatcher(intent: Intent)
}

//data class UIState(
//
//)