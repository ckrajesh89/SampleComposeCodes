package com.example.mysamplecodes.RandomScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mysamplecodes.ui.theme.White_Alpha100
import com.example.mysamplecodes.ui.theme.White_Alpha50

@Composable
fun SampleBackgroundShader(){
    val width = LocalConfiguration.current.screenWidthDp.dp - 10.dp
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(start = 10.dp, end = 10.dp, top = 40.dp, bottom = 20.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(5))
                .border(1.dp, color = White_Alpha50, shape = RoundedCornerShape(5))
                .size(width, 200.dp)
//                .padding(start = 10.dp, end = 10.dp, top = 10.dp, bottom = 10.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RectangleShape)
                    .clip(RoundedCornerShape(5))
                    .width(width)
                    .height(width / 2)
                    .background(
                        brush = Brush.radialGradient(
                            colors = listOf(
                                White_Alpha100.copy(alpha = 0.1f),
                                White_Alpha100.copy(alpha = 0.25f),
                            ),
                            radius = 0.000456789f / 2,
//                            radius = 0.001f / 2,
                            tileMode = TileMode.Repeated
                        )
                    )
                    .padding(10.dp)
            ){
                Text(
                    text = "Box Background Shader White",
                    fontSize = 18.sp,
                    color = Color.White,
                )
            }
        }

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(10))
                .size(width, 200.dp)
                .padding(start = 10.dp, end = 10.dp, top = 10.dp, bottom = 10.dp)
        ) {
            Box(
                modifier = Modifier
                    .clip(RectangleShape)
                    .clip(RoundedCornerShape(10))
                    .width(width)
                    .height(width / 2)
                    .background(
                        brush = Brush.radialGradient(
                            colors = listOf(
//                                    Color(0xFFBCD3E0),
                                Color.Black.copy(alpha = 0.58f),
                                Color.White.copy(alpha = 0.2f),
                            ),
//                            radius = 0.001f / 2,
                            radius = 0.000456789f / 2,
                            tileMode = TileMode.Mirror
                        )
                    )
            )

            Text(
                text = "Box Background Shader White and Black",
                fontSize = 18.sp,
                color = Color.White
            )
        }

        Card(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(10),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 16.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                contentColor = White_Alpha100
            ),
            modifier = Modifier
                .size(width, 200.dp)
                .padding(start = 10.dp, end = 10.dp, top = 10.dp, bottom = 10.dp),
        ) {
            Box {
                Box(
                    modifier = Modifier
                        .clip(RectangleShape)
                        .clip(RoundedCornerShape(10))
                        .width(width)
                        .height(width / 2)
                        .background(
                            brush = Brush.radialGradient(
                                colors = listOf(
//                                    Color(0xFFBCD3E0),
                                    Color.White.copy(alpha = 0.2f),
                                    Color.Black.copy(alpha = 0.4f),
                                ),
//                            radius = 0.001f / 2,
                                radius = 0.000456789f / 2,
                                tileMode = TileMode.Mirror
                            )
                        )
                        .padding(10.dp)
                ){
                    Column(
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier.fillMaxWidth()
                    ){
                        Text(
                            text = "Card Background Shader White and Black",
                            fontSize = 18.sp,
                            color = Color.White
                        )
                    }
                }

            }
        }
    }
}