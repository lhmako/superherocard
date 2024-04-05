package app.lhmako.ui.library.navigation.factory

interface IAppNavigationFactory {
    fun back()
    fun navigateToOnboarding()
    fun navigateToComic(id: String)
    fun navigateToComics()
}