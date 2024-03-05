package com.example.mysamplecodes.Loaders

import android.graphics.ColorSpace
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.TextDelegate.Companion.paint
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.toRect
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.ImageShader
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.asAndroidColorFilter
import androidx.compose.ui.graphics.colorspace.Rgb
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.ColorUtils
import com.example.mysamplecodes.R
import com.example.mysamplecodes.ui.theme.Brown
import com.example.mysamplecodes.ui.theme.White_Alpha00
import com.example.mysamplecodes.ui.theme.White_Alpha100
import com.example.mysamplecodes.ui.theme.White_Alpha20
import com.example.mysamplecodes.ui.theme.White_Alpha30
import com.example.mysamplecodes.ui.theme.White_Alpha50
import kotlinx.coroutines.delay
import kotlin.random.Random

@Composable
fun HomeScreenShimmer1() {
    var isLoadingCompleted by remember { mutableStateOf(false) }
    var isLightModeActive by remember { mutableStateOf(false) }
    var isLoadingImage by remember { mutableStateOf(false) }

    LaunchedEffect(isLoadingImage){
        delay(3000)
//        isLoadingCompleted = !isLoadingCompleted
        isLoadingImage = !isLoadingImage
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = if (isLightModeActive) Color.White else Color.Black)
            .border(border = BorderStroke(width = 4.dp, color = Color.Black))
            .padding(start = 20.dp, end = 20.dp, bottom = 20.dp, top = 40.dp)
    ) {
        Column(
            modifier = Modifier.align(alignment = Alignment.TopCenter)
        ) {

            Column {
                if(isLoadingImage){
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(24.dp))
                            .background(color = Brown)
                            .height(200.dp)
                            .fillMaxWidth()
                    ){
                        Image(painter = painterResource(id = R.drawable.tomato), contentDescription = "image")
                    }
                } else {
                    ComponentRectangle(isLoadingImage, isLightModeActive)
                }
                Spacer(modifier = Modifier.padding(8.dp))
                ComponentRectangleLineLong(isLoadingCompleted, isLightModeActive)
                Spacer(modifier = Modifier.padding(4.dp))
                ComponentRectangleLineShort(isLoadingCompleted, isLightModeActive)
            }

            Spacer(modifier = Modifier.padding(24.dp))

            Row {
                ComponentCircle(isLoadingCompleted, isLightModeActive)
                Spacer(modifier = Modifier.padding(4.dp))
                Column {
                    Spacer(modifier = Modifier.padding(8.dp))
                    ComponentRectangleLineLong(isLoadingCompleted, isLightModeActive)
                    Spacer(modifier = Modifier.padding(4.dp))
                    ComponentRectangleLineShort(isLoadingCompleted, isLightModeActive)
                }
            }
            Spacer(modifier = Modifier.padding(24.dp))

            Row {
                ComponentSquare(isLoadingCompleted, isLightModeActive)
                Spacer(modifier = Modifier.padding(4.dp))
                Column {
                    Spacer(modifier = Modifier.padding(8.dp))
                    ComponentRectangleLineLong(isLoadingCompleted, isLightModeActive)
                    Spacer(modifier = Modifier.padding(4.dp))
                    ComponentRectangleLineShort(isLoadingCompleted, isLightModeActive)
                }
            }

            Spacer(modifier = Modifier.padding(24.dp))
            Row (
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        isLightModeActive = !isLightModeActive
                    },
                    shape = RoundedCornerShape(50)
                ) {
                    Text(
                        text = "Change Theme"
                    )
                }

                Button(
                    onClick = {
                        isLoadingCompleted = !isLoadingCompleted
                    },
                    shape = RoundedCornerShape(50)
                ) {
                    Text(
                        text = "Change Loading Status"
                    )
                }
            }
        }
    }
}

@Composable
fun HomeScreenShimmer2(){
    var isLoading by remember {
        mutableStateOf(true)
    }
    LaunchedEffect(isLoading) {
        delay(5000)
        isLoading = !isLoading
    }
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(5) {
            ShimmerListItem(
                isLoading = isLoading,
                contentAfterLoading = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = null,
                            modifier = Modifier.size(100.dp)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = "This is a long text to show that our shimmer display " +
                                    "is looking perfectly fine"
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
    }
}

@Composable
fun ShimmerListItem(
    isLoading: Boolean,
    contentAfterLoading: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    if(isLoading) {
        Row(modifier = modifier) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray)
                    .shimmerEffect()
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                        .background(Color.LightGray)
                        .shimmerEffect()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .height(20.dp)
                        .background(Color.LightGray)
                        .shimmerEffect()
                )
            }
        }
    } else {
        contentAfterLoading()
    }
}

