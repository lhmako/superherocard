package app.lhmako.ui.library.pages

enum class AppRoute(
    public val route: String
) {
    ONBOARDING("onboarding"),
    COMIC("comic/{id}"),
    COMICS("comics")
}