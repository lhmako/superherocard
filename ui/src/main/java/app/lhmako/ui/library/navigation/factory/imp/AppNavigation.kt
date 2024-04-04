package app.lhmako.ui.library.navigation.factory.imp

import androidx.navigation.NavController
import app.lhmako.ui.library.navigation.factory.IAppNavigationFactory
import app.lhmako.ui.library.pages.AppRoute

class AppNavigation(
    private val navController: NavController
) : IAppNavigationFactory {
    override fun back() {
        navController.popBackStack()
    }

    override fun navigateToOnboarding() {
        navController.navigate(AppRoute.ONBOARDING.route)
    }

    override fun navigateToComic() {
        navController.navigate(AppRoute.COMIC.route)
    }

    override fun navigateToComics() {
        navController.navigate(AppRoute.COMICS.route)
    }

}