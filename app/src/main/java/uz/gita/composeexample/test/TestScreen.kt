package uz.gita.composeexample.test

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import uz.gita.composeexample.data.models.QuestionData
import uz.gita.composeexample.ui.theme.AppTheme

class TestScreen : AndroidScreen() {

    @Composable
    override fun Content() {
        val viewModel: TestViewModel = getViewModel<TestViewModelImpl>()
        val uiState = viewModel.uiState.collectAsState().value


        AppTheme {
            TestScreenContent(uiState, viewModel::onEventDispatcher)
        }
    }
}

@Composable
fun TestScreenContent(
    uiState: UIState?,
    eventDispatcher: (Intent) -> Unit
) {
    if (uiState != null) {
        Surface(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = CenterHorizontally
                ) {

                    Text(
                        text =
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(color = Color.Blue, fontSize = 22.sp)) {
                                append(uiState.current.toString())
                            }
                            append("/${uiState.allCount}")
                        },
                        fontSize = 18.sp
                    )

                    QuestionBox(uiState, eventDispatcher)

                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        enabled = uiState.selected != null,
                        onClick = { eventDispatcher(Intent.NEXT) },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
                    ) {
                        Text(text = "NEXT")
                    }
                }

            }
        }
    }

}

@Composable
fun QuestionBox(
    uiState: UIState,
    eventDispatcher: (Intent) -> Unit
) {
    Box {
        Column {
            Question(uiState.question)
            Variant(text = uiState.question.var1, uiState.selected) { eventDispatcher(Intent.VAR1) }
            Variant(text = uiState.question.var2, uiState.selected) { eventDispatcher(Intent.VAR2) }
            Variant(text = uiState.question.var3, uiState.selected) { eventDispatcher(Intent.VAR3) }
            Variant(text = uiState.question.var4, uiState.selected) { eventDispatcher(Intent.VAR4) }
        }
    }
}

@Composable
fun Question(questionData: QuestionData) {
    Log.d("RRR", "Question")
    Box(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .background(Color.Red)
    ) {
        Text(
            text = questionData.question,
            textAlign = TextAlign.Center,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp, 20.dp)
                .fillMaxWidth()
        )
    }
}

@Composable
fun Variant(
    text: String,
    selected: String?,
    action: () -> Unit

) {
    Log.d("RRR", "Variant")
    Box(
        modifier = Modifier
            .padding(20.dp, 10.dp)
            .fillMaxWidth()
            .background(if (selected == text) Color.Yellow else Color.LightGray)
            .clickable(
                enabled = true,
                onClick = {
                    action()
                }
            )
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp, 5.dp)
                .fillMaxWidth()
        )
    }
}




