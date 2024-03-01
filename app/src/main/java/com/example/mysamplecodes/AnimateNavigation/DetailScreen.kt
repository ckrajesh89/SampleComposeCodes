package com.example.mysamplecodes.AnimateNavigation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mysamplecodes.ui.theme.Brown
import com.example.mysamplecodes.ui.theme.White_Alpha100
import com.example.mysamplecodes.ui.theme.verticalGradient

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(item:Vegetables?, onBackClick:() -> Unit){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = verticalGradient)
    ){
        Scaffold(
            containerColor = Color.Transparent,
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Brown
                    ),
                    title = {
                        Text(
                            text = item?.name ?: "",
                            color = White_Alpha100
                        )
                    },
                    navigationIcon = {
                        Icon(
                            imageVector = Icons.Filled.ArrowBackIosNew,
                            contentDescription = "",
                            tint = White_Alpha100,
                            modifier = Modifier.clickable {
                                onBackClick()
                            }
                        )
                    }
                )
            }
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 100.dp, start = 10.dp, end = 10.dp, bottom = 20.dp)
            ) {
                item{
                    Card(
                        shape = RoundedCornerShape(10),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 16.dp
                        ),
                        colors = CardDefaults.cardColors(
                            containerColor = Brown
                        )
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.height(100.dp)
                        ) {
                            Image(
                                painter = painterResource(id = item?.image ?: 0),
                                contentDescription = "",
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier.weight(0.2f)
                            )
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.Start,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(0.8f)
                            ) {
                                Text(text = item?.name ?: "",color = White_Alpha100, fontWeight = FontWeight.Bold)
                                Text(text = item?.measurement ?: "",color = White_Alpha100)
                                Text(text = item?.calories ?: "",color = White_Alpha100)
                            }
                        }
                    }
                }

                item{
                    Text(text = item?.details ?: "",color = White_Alpha100)
                }

                item?.benefits?.let { benefits ->
                    if(benefits.isNotEmpty()){
                        item {
                            Card(
                                shape = RoundedCornerShape(10),
                                elevation = CardDefaults.cardElevation(
                                    defaultElevation = 16.dp
                                ),
                                colors = CardDefaults.cardColors(
                                    containerColor = Brown
                                ),
                            ) {
                                Column(
                                    verticalArrangement = Arrangement.Top,
                                    horizontalAlignment = Alignment.Start,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(10.dp)
                                ) {
                                    Text(
                                        text = "Benefits",
                                        color = White_Alpha100,
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.SemiBold
                                    )

                                    benefits.forEach { benefit ->
                                        Text(
                                            text = "* $benefit",
                                            color = White_Alpha100,
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight.Normal
                                        )
                                    }
                                }
                            }
                        }
                    }
                }

                item?.drawback?.let { drawbacks ->
                    if(drawbacks.isNotEmpty()){
                        item {
                            Card(
                                shape = RoundedCornerShape(10),
                                elevation = CardDefaults.cardElevation(
                                    defaultElevation = 16.dp
                                ),
                                colors = CardDefaults.cardColors(
                                    containerColor = Brown
                                ),
                            ) {
                                Column(
                                    verticalArrangement = Arrangement.Top,
                                    horizontalAlignment = Alignment.Start,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(10.dp)
                                ) {
                                    Text(
                                        text = "Drawbacks",
                                        color = White_Alpha100,
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.SemiBold
                                    )

                                    drawbacks.forEach { drawback ->
                                        Text(
                                            text = "* $drawback",
                                            color = White_Alpha100,
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight.Normal
                                        )
                                    }
                                }
                            }
                        }
                    }
                }

                item{
                    Button(
                        onClick = { onBackClick()},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = White_Alpha100,
                            contentColor = Brown
                        )
                    ) {
                        Text(
                            text = "Close",
                            color = Brown
                        )
                    }
                }
                
                item{
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }
    }
}