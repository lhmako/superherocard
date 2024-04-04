package app.lhmako.ui.library.pages

import app.lhmako.ui.adpaters.IAppResourcesAdapter
import app.lhmako.ui.library.navigation.factory.IAppNavigationFactory
import app.lhmako.ui.pages.comic.list.ComicsPage
import app.lhmako.ui.pages.comic.list.viewmodel.ComicsViewModel
import app.lhmako.ui.pages.comic.overview.ComicOverviewPage
import app.lhmako.ui.pages.onboarding.OnboardingPage

class AppPageFactory(
    private val appNavigationFactory: IAppNavigationFactory,
    private val appResources: IAppResourcesAdapter
) {
    val onboarding: IAppPage get() = OnboardingPage(appNavigationFactory = appNavigationFactory)
    val comics: IAppPage get() = ComicOverviewPage(appNavigationFactory = appNavigationFactory)
    val comic: IAppPage
        get() = ComicsPage(
            appNavigationFactory = appNavigationFactory,
            comicsViewModel = ComicsViewModel(appResources.comicsDataAdapter)
        )
}