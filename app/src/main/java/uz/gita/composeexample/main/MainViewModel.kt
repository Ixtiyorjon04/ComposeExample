package uz.gita.composeexample.main

import kotlinx.coroutines.flow.StateFlow

interface MainViewModel {

    fun onEventDispatcher(intent: Intent)
}

enum class Intent() {
    START, QUIT
}

data class UIState(
    val startButton: Unit,
    val quitButton: Unit
)