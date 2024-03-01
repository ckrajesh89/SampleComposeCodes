package com.example.mysamplecodes.AnimateNavigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mysamplecodes.R
import com.example.mysamplecodes.ui.theme.Brown
import com.example.mysamplecodes.ui.theme.White_Alpha100
import com.example.mysamplecodes.ui.theme.verticalGradient

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MainScreen(itemList:List<Vegetables>, onClick:(String) -> Unit){
    val screenSize: Dp = LocalConfiguration.current.screenWidthDp.dp
    val adjustedScreenSize = (screenSize - 80.dp) / 3
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = verticalGradient)
    ){
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)
        ) {
            item {
                Text(
                    text = "Vegetables",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = White_Alpha100
                )
            }

            item {
                FlowRow(
                    horizontalArrangement = Arrangement.Start,
                    verticalArrangement = Arrangement.Top,
                    maxItemsInEachRow = 3,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    itemList.forEach { veg ->
                        Card(
                            shape = RoundedCornerShape(10),
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 12.dp
                            ),
                            modifier = Modifier
                                .padding(10.dp)
                                .size(adjustedScreenSize)
                                .clickable {
                                    onClick(veg.code)
                                },
                            colors = CardDefaults.cardColors(
                                containerColor = Brown,
                                contentColor = White_Alpha100
                            )
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Image(
                                    painter = painterResource(id = veg.image),
                                    contentDescription = "",
                                    contentScale = ContentScale.FillBounds,
                                    modifier = Modifier.size(80.dp)
                                )
                                Text(
                                    text = veg.name,
                                    color = White_Alpha100,
                                )
                            }
                        }
                    }
                }
            }

//This is working. But need to work around to making fullscreen.
//            item{
//                Box(
//                    contentAlignment = Alignment.Center,
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .aspectRatio(16f / 12f)
//                        .clip(RoundedCornerShape(10.dp))
//                        .background(Color.Black)
//                ){
//                    YouTubePlayer(url = "https://www.youtube.com/embed/4QrYk6DzwJE")
//                }
//            }
        }
    }
}