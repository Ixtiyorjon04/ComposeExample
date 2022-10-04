package uz.gita.composeexample.demo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import uz.gita.composeexample.R
import uz.gita.composeexample.ui.theme.AppTheme

class ContactScreen : AndroidScreen() {

    val contacts = listOf<ContactData>(
        ContactData(
            "Shahrizod",
            R.drawable.ic_launcher_background,
            "+998901363114"
        ),
        ContactData(
            "Shahrizod",
            R.drawable.ic_launcher_background,
            "+998901363114"
        ),
        ContactData(
            "Shahrizod",
            R.drawable.ic_launcher_background,
            "+998901363114"
        ),
        ContactData(
            "Shahrizod",
            R.drawable.ic_launcher_background,
            "+998901363114"
        ),
        ContactData(
            "Shahrizod",
            R.drawable.ic_launcher_background,
            "+998901363114"
        )
    )

    @Composable
    override fun Content() {
        AppTheme {
            Surface {
                Box(Modifier.fillMaxSize()) {
                    ContactList(list = contacts)

//                    ContactItem(
//                        data = ContactData(
//                            "Shahrizod",
//                            R.drawable.ic_launcher_background,
//                            "+998901363114"
//                        )
//                    )
                }
            }
        }
    }

}

@Composable
fun ContactList(list: List<ContactData>) {
    LazyColumn() {

        item {
            LazyRow() {
                items(list.size) {
                    ContactItem(data = list[it])
                }
            }
        }
        items(list.size) {
            ContactItem(data = list[it])
        }
    }
}


@Composable
private fun ContactItem(data: ContactData) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = data.image),
                contentDescription = "Hechnima yo'q",
                modifier = Modifier.size(60.dp),

                )
            Column(Modifier.padding(start = 10.dp)) {
                Text(
                    text = data.name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = data.phoneNumber,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}

//@Composable
//@Preview
//fun ContactItemPreview() {
//
//    ContactItem(
//        data = ContactData(
//            "Shahrizod",
//            R.drawable.ic_launcher_background,
//            "+998901363114"
//        )
//    )
//
//}

