package app.lhmako.ui.library.pages

import app.lhmako.ui.library.navigation.factory.IAppNavigationFactory
import app.lhmako.ui.pages.comic.list.ComicsPage
import app.lhmako.ui.pages.comic.overview.ComicOverviewPage
import app.lhmako.ui.pages.onboarding.OnboardingPage

class AppPageFactory(
    private val appNavigationFactory: IAppNavigationFactory
) {
    val onboarding: IAppPage by lazy { OnboardingPage(appNavigationFactory = appNavigationFactory) }
    val comic: IAppPage by lazy { ComicOverviewPage(appNavigationFactory = appNavigationFactory) }
    val comics: IAppPage by lazy { ComicsPage(appNavigationFactory = appNavigationFactory) }
}