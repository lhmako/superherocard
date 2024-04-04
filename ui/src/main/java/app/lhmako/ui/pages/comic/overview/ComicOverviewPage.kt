package app.lhmako.ui.pages.comic.overview

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import app.lhmako.ui.library.navigation.factory.IAppNavigationFactory
import app.lhmako.ui.library.pages.AppRoute
import app.lhmako.ui.library.pages.IAppPage

class ComicOverviewPage(
    override val route: AppRoute = AppRoute.COMIC,
    override val appNavigationFactory: IAppNavigationFactory
) : IAppPage {

    @Composable
    override operator fun invoke() {
        Text(text = "Comic overview")
    }
}