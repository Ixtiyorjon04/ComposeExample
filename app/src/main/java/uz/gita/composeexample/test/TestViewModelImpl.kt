package uz.gita.composeexample.test

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import uz.gita.composeexample.data.models.QuestionData
import uz.gita.composeexample.data.repository.TestRepository
import javax.inject.Inject

@HiltViewModel
class TestViewModelImpl @Inject constructor(
    private val testRepository: TestRepository
) : TestViewModel, ViewModel() {

    override val uiState = MutableStateFlow<UIState?>(null)

    private var current = 0
    private lateinit var tests: List<QuestionData>

    init {
        viewModelScope.launch {
            tests = testRepository.getTests()
            uiState.tryEmit(UIState(tests[current], tests.size, current + 1, null))
        }
    }


    override fun onEventDispatcher(intent: Intent) {
        when (intent) {
            Intent.VAR1 -> {
                reduce { it.copy(selected = tests[current].var1) }
            }
            Intent.VAR2 -> {
                reduce { it.copy(selected = tests[current].var2) }
            }
            Intent.VAR3 -> {
                reduce { it.copy(selected = tests[current].var3) }
            }
            Intent.VAR4 -> {
                reduce { it.copy(selected = tests[current].var4) }
            }
            Intent.NEXT -> {
                if (current != tests.size - 1) {
                    current++
                    reduce {
                        it.copy(
                            selected = null,
                            current = current + 1,
                            question = tests[current]
                        )
                    }
                } else {

                }
            }
        }
    }

    private fun reduce(block: (UIState) -> UIState) {
        val old = uiState.value!!
        val new = block(old)
        uiState.tryEmit(new)
    }
}

enum class Intent {
    VAR1, VAR2, VAR3, VAR4, NEXT
}

data class UIState(
    val question: QuestionData,
    val allCount: Int,
    val current: Int,
    val selected: String?
)