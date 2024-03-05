package com.example.mysamplecodes.AnimateNavigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mysamplecodes.R
import com.example.mysamplecodes.ui.theme.Brown
import com.example.mysamplecodes.ui.theme.White_Alpha30

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun BlurredBackgroundContent() {
    // Image resource for the background
    val backgroundImageResource = R.drawable.tomato
    val scrollPosition = 400 // Replace with your actual scroll position
    val blurRadiues = 5.dp
    val scrollState = rememberLazyListState()
    var isContentOnTop by remember { mutableStateOf(false) }
    val threshold = with(LocalDensity.current) { 200.dp.toPx() }

    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier
            .fillMaxSize()
            .background(Brown)
    ) {
        // Background image with blur effect
        Box(
            modifier = Modifier
                .blur(blurRadiues)
        ){
            Image(
                painter = painterResource(id = backgroundImageResource),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(100.dp)
            )
        }

        // Detect scroll position
        LaunchedEffect(key1 = remember { derivedStateOf { scrollState.firstVisibleItemIndex } }) {
            scrollState.scrollToItem(0)
            // Determine if content is on top of background image
            isContentOnTop = scrollState.firstVisibleItemIndex == 0
        }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(30.dp),
            modifier = Modifier.fillMaxSize(),
            state = scrollState
        ) {
            items(20) { index ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = White_Alpha30
                    )
                ) {
                    Text(
                        text = "I will make you blur",
                        modifier = Modifier
                            .padding(horizontal = 10.dp, vertical = 10.dp)
                    )
                }
            }
        }
    }
}


// Function to calculate alpha based on scroll position
fun calculateAlphaForScrollPosition(scrollPosition: Int): Float {
    // Adjust this value based on how much you want the background to blur
    val maxScrollPosition = 200
    val alphaValue = scrollPosition.coerceIn(0, maxScrollPosition) / maxScrollPosition
    // Adjust the range of alpha values based on your preference
    return alphaValue * 0.5f // 0.5f is the maximum alpha value (fully blurred)
}