package com.icode.co_opt_1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Main content of application
 */
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

val animals = listOf(
    R.drawable.dog,
    R.drawable.cat,
    R.drawable.lion,
    R.drawable.tiger,
)

val animalsName = listOf(
    "Dog",
    "Cat",
    "Lion",
    "Tiger",
)

var translation: String = ""


/**
 * This function renders swipeable pages.
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SwipeablePages() {

    val pageCount = animals.size
    val pagerState = rememberPagerState()

    /**
     * A pager that scrolls horizontally
     * @param pageCount The amount of pages this Pager will have
     * @param state The state to control this pager
     * @param key an unique key representing the item
     */
    HorizontalPager(
        pageCount = pageCount,
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
                modifier = Modifier
                    .fillMaxWidth(),
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
                    .padding(10.dp)
                    .align(CenterHorizontally)
                    .fillMaxWidth()
                    .clickable {
                        expanded = !expanded
                        if (expanded){
                            translateText(animalsName[index])
                        }
                    }
            )

            AnimatedVisibility(expanded) {
                Column(verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = translation,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                        style = TextStyle(
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    BtnPlay(onClick = { Log.d("FAB", " clicked.") })
                }
            }
        }
    }


    Row(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom,
    ) {
        repeat(pageCount) { iteration ->
            val color = if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(20.dp)
            )
        }
    }
}


@Composable
fun BtnPlay(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = { onClick() },
        modifier = Modifier.padding(10.dp)
    ) {
        Icon(Icons.Filled.PlayArrow, "Floating action button.")
    }
}



// Translate text into the target language
fun translateText(text: String) {
    translation = ""
    val request = TranslateRequest(q = text, source = "en", target = "pt")

    // Send asynchronous HTTP request using enqueue() method (for synchronous request, use execute())
    ApiService.instance.translate(request).enqueue(object : Callback<TranslateResponse> {
        override fun onResponse(call: Call<TranslateResponse>, response: Response<TranslateResponse>) {
            if (response.isSuccessful) {
                // Handle data
                val translatedText = response.body()?.translatedText
                if (translatedText != null)
                {
                    translation = translatedText
                    Log.d("test", translation) // print the translated text in logcat
                }
            } else {
                // Handle error
            }
        }

        override fun onFailure(call: Call<TranslateResponse>, t: Throwable) {
            // Handle failure of the request
        }
    })
}