package app.lhmako.ui.library.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import app.lhmako.ui.library.pages.AppPageFactory
import app.lhmako.ui.library.pages.AppRoute
import app.lhmako.ui.library.pages.IAppPage

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    pageFactory: AppPageFactory,
    startDestination: AppRoute = AppRoute.ONBOARDING
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination.route
    ) {
        composable(pageFactory.onboarding)
        composable(pageFactory.comics)
        composable(pageFactory.comic)
    }
}

fun NavGraphBuilder.composable(
    appPage: IAppPage,
    content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit = { appPage() }
) {
    composable(appPage.route.route, content = content)
}