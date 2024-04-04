package app.lhmako.ui.library.pages

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import app.lhmako.ui.library.navigation.factory.IAppNavigationFactory

interface IAppPage {
    val route: AppRoute
    val appNavigationFactory: IAppNavigationFactory
    @Composable
    operator fun invoke()
}