package uz.gita.composeexample.main

import android.widget.Toast
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import uz.gita.composeexample.demo.ContactScreen
import uz.gita.composeexample.test.TestScreen
import uz.gita.composeexample.ui.theme.AppTheme

class MainScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        MainScreenContent()
    }
}

@Composable
fun MainScreenContent() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val navigator = LocalNavigator.currentOrThrow
        Box(
            modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
        ) {
            Column {
                MenuChoiceButton(text = "Start") {
                    navigator.push(TestScreen())
                }
                MenuChoiceButton(text = "Quit") {
                    navigator.push(ContactScreen())
                }
            }
        }
    }
}

@Composable
fun MenuChoiceButton(
    text: String,
    action: () -> Unit
) {

    Button(
        modifier = Modifier
            .padding(40.dp, 10.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
        onClick = { action() }) {
        Text(text = text, color = Color.Black)
    }

}


//@Composable
//@Preview
//fun MainScreenPreview() {
//    AppTheme {
//        MainScreenContent()
//    }
//}

