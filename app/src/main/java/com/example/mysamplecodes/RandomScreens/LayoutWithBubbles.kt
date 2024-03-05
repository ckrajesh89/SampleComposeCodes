package com.example.mysamplecodes.RandomScreens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mysamplecodes.ui.theme.White_Alpha100
import com.example.mysamplecodes.ui.theme.White_Alpha50
import com.example.mysamplecodes.ui.theme.gradientTest
import com.example.mysamplecodes.ui.theme.verticalGradient

data class TableCell(
    val session: String,
    val status: String,
    val rating: String
)
@Composable
fun LayoutWithBubbles(){
    val width = LocalConfiguration.current.screenWidthDp.dp - 10.dp
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ){
        Canvas(
            modifier = Modifier.size(200.dp)
        ) {
            drawGradientShadeFromTop()
        }

        Box(
            contentAlignment = Alignment.BottomEnd,
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 40.dp)
                .blur(16.dp)
        ){
            Canvas(
                modifier = Modifier.size(200.dp)
            ) {
                drawGradientSemiCircle()
            }
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(5))
                    .border(1.dp, color = White_Alpha50, shape = RoundedCornerShape(5))
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
                        text = "Im inside the box",
                        fontSize = 18.sp,
                        color = Color.White,
                    )
                }
            }

            Box(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .clip(RectangleShape)
                    .clip(RoundedCornerShape(5))
//                    .width(width)
//                    .height(width / 2)
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
//                    .padding(10.dp)
            ){
                val tableCellList = listOf(
                    TableCell(session = "Session", status = "Status", rating = "Rating"),
                    TableCell(session = "Morning", status = "Login Your Meal", rating = "Abdominal Pain"),
                    TableCell(session = "Morning Snacks", status = "Done", rating = "Bad"),
                    TableCell(session = "Lunch", status = "Done", rating = "Excellent"),
                    TableCell(session = "Evening Snacks", status = "Done", rating = "Good"),
                    TableCell(session = "Dinner", status = "Done", rating = "Good"),
                )
//                @Composable
//                fun ExcelGridWithText() {
                    Column(modifier = Modifier.fillMaxSize()) {
                        tableCellList.forEachIndexed { rowIndex, tableCell ->
                            val color = when (rowIndex) {
                                0 -> Color(0xff22c7db)
                                else -> White_Alpha100
                            }
                            val size = when (rowIndex) {
                                0 -> 16.sp
                                else -> 12.sp
                            }
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                repeat(3) { columnIndex ->
                                    val weight = if(columnIndex == 2) 0.4f else 0.3f
                                    val text = when (columnIndex) {
                                        0 -> tableCell.session
                                        1 -> tableCell.status
                                        else -> tableCell.rating
                                    }
                                    val arrangement = when (columnIndex) {
                                        2 -> Arrangement.End
                                        else -> Arrangement.Center
                                    }
                                    val padding = when (columnIndex) {
                                        2 -> 10.dp
                                        else -> 0.dp
                                    }
                                    
                                    Box(
                                        modifier = Modifier
                                            .weight(weight)
                                            .height(70.dp)
                                            .border(border = BorderStroke(2.dp, Color.Black))
                                            .padding(4.dp),
                                        contentAlignment = Alignment.Center,

                                    ) {
                                        Row(
                                            horizontalArrangement = arrangement,
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier.fillMaxWidth().padding(end = padding)
                                        ){
                                            Text(
                                                text = text,
                                                fontSize = size,
                                                color = color,
                                                maxLines = 2,
                                                fontWeight = FontWeight.Normal,
                                                textAlign = TextAlign.Center,
                                                softWrap = true,
                                                modifier = Modifier.padding(8.dp).weight(0.7f)
                                            )
                                            if(columnIndex == 2 && rowIndex != 0){
                                                Spacer(modifier = Modifier.width(5.dp))
                                                Icon(
                                                    imageVector = Icons.Filled.Circle,
                                                    contentDescription = "",
                                                    tint = White_Alpha100,
                                                    modifier = Modifier.size(40.dp).weight(0.3f)
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
//                }
            }

            Text(
                text = "This is big description",
                color = White_Alpha100
            )

            repeat(16){
                Text(
                    text = "You can configure the color stops to have different amounts, such as less or more of one color.",
                    color = White_Alpha100,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }

    }
}

private fun DrawScope.drawGradientShadeFromTop() {
//    val shader = Brush.linearGradient(
//        colors = listOf(
////            Color(0xff2aecd6),
//            Color(0xff22c7db),
//            Color(0xff22c7db),
//            Color.Transparent),
//        start = Offset(0f,0f),
//        end = Offset(200f,200f),
//        tileMode = TileMode.Decal
//    )
//    drawRect(
//        brush = shader,
//        topLeft = Offset.Zero,
//        size = size,
//    )

    val shader = Brush.linearGradient(
        colors = listOf(
            Color(0xff2aecd6),
            Color(0xff22c7db),
            Color(0x8022c7db),
            Color.Transparent,
        ),
        start = Offset(0f,0f),
        end = Offset(250f,250f),
        tileMode = TileMode.Decal
    )

    drawCircle(
        brush = shader,
        radius = size.width,
        center = Offset(size.width - (size.width / 2),0f),
    )
}

private fun DrawScope.drawGradientSemiCircle() {
    val brush = Brush.verticalGradient(
        colors = listOf(
            Color(0xff2aecd6),
            Color(0xff22c7db),
            Color(0xff14a0e2),
            Color(0xff0b71ea)
        ),
        tileMode = TileMode.Clamp
    )

    drawCircle(
        brush = brush,
        radius = size.width,
        center = Offset(size.width * 1.75f,0f),
    )
}
