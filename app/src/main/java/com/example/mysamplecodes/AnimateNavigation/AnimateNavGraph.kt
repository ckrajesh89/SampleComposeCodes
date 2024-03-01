package com.example.mysamplecodes.AnimateNavigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mysamplecodes.ui.theme.MySampleCodesTheme

sealed class StartingScreen(val route: String) {
    object MainScreen : StartingScreen("main_screen")
    object DetailScreen : StartingScreen("detail_Screen")
}

enum class ScaleTransitionDirection{
    INWARDS,
    OUTWARDS
}

fun scaleIntoContainer(
    direction: ScaleTransitionDirection = ScaleTransitionDirection.INWARDS,
    initialScale: Float = if (direction == ScaleTransitionDirection.OUTWARDS) 0.9f else 1.1f
): EnterTransition {
    return scaleIn(
        animationSpec = tween(220, delayMillis = 90),
        initialScale = initialScale
    ) + fadeIn(animationSpec = tween(220, delayMillis = 90))
}

fun scaleOutOfContainer(
    direction: ScaleTransitionDirection = ScaleTransitionDirection.OUTWARDS,
    targetScale: Float = if (direction == ScaleTransitionDirection.INWARDS) 0.9f else 1.1f
): ExitTransition {
    return scaleOut(
        animationSpec = tween(
            durationMillis = 220,
            delayMillis = 90
        ), targetScale = targetScale
    ) + fadeOut(tween(delayMillis = 90))
}

@Composable
fun AnimateNavigation() {
    val navController = rememberNavController()
    val startDestination = StartingScreen.MainScreen.route
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(
            route = StartingScreen.MainScreen.route,
            enterTransition = {
                scaleIntoContainer()
//                slideIntoContainer(
//                    towards = AnimatedContentTransitionScope.SlideDirection.Left,
//                    animationSpec = tween(700)
//                )
            },
            exitTransition = {
                scaleOutOfContainer(direction = ScaleTransitionDirection.INWARDS)
//                slideOutOfContainer(
//                    towards = AnimatedContentTransitionScope.SlideDirection.Left,
//                    animationSpec = tween(700)
//                )
            },
            popEnterTransition = {
                scaleIntoContainer(direction = ScaleTransitionDirection.OUTWARDS)
//                slideIntoContainer(
//                    towards = AnimatedContentTransitionScope.SlideDirection.Right,
//                    animationSpec = tween(700)
//                )
            },
            popExitTransition = {
                scaleOutOfContainer()
//                slideOutOfContainer(
//                    towards = AnimatedContentTransitionScope.SlideDirection.Right,
//                    animationSpec = tween(700)
//                )
            }
        ) {
            MainScreen(
                itemList = vegList,
                onClick = { code ->
                    navController.navigate(StartingScreen.DetailScreen.route + "/$code")
                }
            )
        }

        composable(
            route = StartingScreen.DetailScreen.route + "/{code}",
            arguments = listOf(navArgument(name = "code") {
                type = NavType.StringType
            }),
            enterTransition = {
                scaleIntoContainer()
//                slideIntoContainer(
//                    towards = AnimatedContentTransitionScope.SlideDirection.Left,
//                    animationSpec = tween(700)
//                )
            },
            exitTransition = {
                scaleOutOfContainer(direction = ScaleTransitionDirection.INWARDS)
//                slideOutOfContainer(
//                    towards = AnimatedContentTransitionScope.SlideDirection.Left,
//                    animationSpec = tween(700)
//                )
            },
            popEnterTransition = {
                scaleIntoContainer(direction = ScaleTransitionDirection.OUTWARDS)
//                slideIntoContainer(
//                    towards = AnimatedContentTransitionScope.SlideDirection.Right,
//                    animationSpec = tween(700)
//                )
            },
            popExitTransition = {
                scaleOutOfContainer()
//                slideOutOfContainer(
//                    towards = AnimatedContentTransitionScope.SlideDirection.Right,
//                    animationSpec = tween(700)
//                )
            }
        ) {
            val vegCode = it.arguments?.getString("code") ?: ""
            val itemDetails = vegList.find { it.code == vegCode }
            DetailScreen(itemDetails,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MySampleCodesTheme {
        AnimateNavigation()
    }
}