package com.icode.co_opt_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.icode.co_opt_1.ui.theme.Co_opt_1Theme
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Co_opt_1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    JetpackCompose()
                }
            }
        }
    }
}

//@Composable
//fun JetpackCompose() {
//    Card {
//        var expanded by remember { mutableStateOf(false) }
//        Column(Modifier.clickable { expanded =!expanded }) {
//            Image(painterResource(R.drawable.test), "Card image")
//            AnimatedVisibility(expanded) {
//                Text(
//                    text = "Animal",
//                    style = MaterialTheme.typography.bodyLarge
//                )
//            }
//        }
//    }
//}

@Composable
fun JetpackCompose() {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        Column() {
            var expanded by remember { mutableStateOf(false) }
            Column(Modifier.clickable { expanded =!expanded }) {
                Image(painterResource(R.drawable.test), "Card image")
                AnimatedVisibility(expanded) {
                    Text(
                        text = "Animal",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }

        Column() {
            var expanded by remember { mutableStateOf(false) }
            Column(Modifier.clickable { expanded =!expanded }) {
                Image(painterResource(R.drawable.test), "Card image")
                AnimatedVisibility(expanded) {
                    Text(
                        text = "Animal",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }

    }
}