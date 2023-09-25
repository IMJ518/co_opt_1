package com.icode.co_opt_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
                    SwipeablePages()
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SwipeablePages() {
    val animals = listOf(
        R.drawable.test,
        R.drawable.test2,
    )

    val animalsName = listOf(
        "Fox",
        "Racoon"
    )

    val animalsTranslation = listOf(
        "여우",
        "라쿤"
    )

    val pagerState = rememberPagerState()


    HorizontalPager(
        pageCount = animals.size,
        state = pagerState,
        key = { animals[it] }
    ) { index ->
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            var expanded by remember { mutableStateOf(false) }

            Text(
                text = animalsName[index],
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Image(
                painter = painterResource(id = animals[index]),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .requiredSize(350.dp)
                    .align(CenterHorizontally)
                    .fillMaxWidth()
                    .clickable { expanded = !expanded }
            )

            AnimatedVisibility(expanded) {
                Text(
                    text = animalsTranslation[index],
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}

//@Composable
//fun JetpackCompose() {
//    Row(
//        Modifier.horizontalScroll(rememberScrollState()),
//        horizontalArrangement = Arrangement.SpaceEvenly,
//        verticalAlignment = Alignment.CenterVertically
//
//
//    ) {
//        Column(
//            Modifier
//                .padding(20.dp)
//                .fillMaxWidth()) {
//            var expanded by remember { mutableStateOf(false) }
//
//            Text(
//                text = "First animal",
//                textAlign = TextAlign.Center,
//                modifier = Modifier.fillMaxWidth(),
//                style = TextStyle(
//                    fontSize = 30.sp,
//                    fontWeight = FontWeight.Bold
//                )
//            )
//            Image(painterResource(R.drawable.test), "Card image",
//                Modifier
//                    .requiredSize(350.dp)
//                    .align(CenterHorizontally)
//                    .clickable { expanded = !expanded })
//            AnimatedVisibility(expanded) {
//                Text(
//                    text = "Animal",
//                    textAlign = TextAlign.Center,
//                    modifier = Modifier.fillMaxWidth(),
//                    style = TextStyle(
//                        fontSize = 30.sp,
//                        fontWeight = FontWeight.Bold
//                    )
//                )
//            }
//        }
//
//        Column(
//            Modifier
//                .padding(20.dp)
//                .fillMaxWidth()) {
//            var expanded by remember { mutableStateOf(false) }
//
//            Text(
//                text = "Second animal",
//                textAlign = TextAlign.Center,
//                modifier = Modifier.fillMaxWidth(),
//                style = TextStyle(
//                    fontSize = 30.sp,
//                    fontWeight = FontWeight.Bold
//                )
//            )
//            Image(painterResource(R.drawable.test), "Card image",
//                Modifier
//                    .requiredSize(350.dp)
//                    .align(CenterHorizontally)
//                    .clickable { expanded = !expanded })
//            AnimatedVisibility(expanded) {
//                Text(
//                    text = "Animal",
//                    textAlign = TextAlign.Center,
//                    modifier = Modifier.fillMaxWidth(),
//                    style = TextStyle(
//                        fontSize = 30.sp,
//                        fontWeight = FontWeight.Bold
//                    )
//                )
//            }
//        }
//
//        Column(
//            Modifier
//                .padding(20.dp)
//                .fillMaxWidth()) {
//            var expanded by remember { mutableStateOf(false) }
//
//            Text(
//                text = "Third animal",
//                textAlign = TextAlign.Center,
//                modifier = Modifier.fillMaxWidth(),
//                style = TextStyle(
//                    fontSize = 30.sp,
//                    fontWeight = FontWeight.Bold
//                )
//            )
//            Image(painterResource(R.drawable.test), "Card image",
//                Modifier
//                    .requiredSize(350.dp)
//                    .align(CenterHorizontally)
//                    .clickable { expanded = !expanded })
//            AnimatedVisibility(expanded) {
//                Text(
//                    text = "Animal",
//                    textAlign = TextAlign.Center,
//                    modifier = Modifier.fillMaxWidth(),
//                    style = TextStyle(
//                        fontSize = 30.sp,
//                        fontWeight = FontWeight.Bold
//                    )
//                )
//            }
//        }
//    }
//}