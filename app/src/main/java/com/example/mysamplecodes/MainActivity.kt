package com.example.mysamplecodes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.mysamplecodes.Loaders.HomeScreenShimmer1
import com.example.mysamplecodes.Loaders.HomeScreenShimmer2
import com.example.mysamplecodes.RandomScreens.LayoutWithBottomBox
import com.example.mysamplecodes.RandomScreens.LayoutWithBubbles
import com.example.mysamplecodes.RandomScreens.SampleBackgroundShader
import com.example.mysamplecodes.ui.theme.MySampleCodesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MySampleCodesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    SampleForm()
//                    AnimateNavigation()
//                    BlurredBackgroundContent()
//                    HomeScreenShimmer1()
//                    HomeScreenShimmer2()
//                    SampleBackgroundShader()
//                    LayoutWithBottomBox()
                    LayoutWithBubbles()
                }
            }
        }
    }
}
