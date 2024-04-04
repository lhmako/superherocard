package app.lhmako.ui.pages.comic.list

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import app.lhmako.ui.guideline.theme.Purple80
import app.lhmako.ui.library.navigation.factory.IAppNavigationFactory
import app.lhmako.ui.library.pages.AppRoute
import app.lhmako.ui.library.pages.IAppPage

class ComicsPage(
    override val route: AppRoute = AppRoute.COMICS,
    override val appNavigationFactory: IAppNavigationFactory
) : IAppPage {

    @Composable
    override operator fun invoke() {
        Text(text = "Comics list", color = Purple80)
    }

}