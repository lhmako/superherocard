package app.lhmako.ui.pages.comic.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import app.lhmako.ui.R
import app.lhmako.ui.guideline.buttons.PrimaryButton
import app.lhmako.ui.guideline.theme.Brown
import app.lhmako.ui.library.navigation.factory.IAppNavigationFactory
import app.lhmako.ui.library.pages.AppRoute
import app.lhmako.ui.library.pages.IAppPage
import app.lhmako.ui.pages.comic.list.viewmodel.ComicsViewModel

class ComicsPage(
    override val route: AppRoute = AppRoute.COMICS,
    override val appNavigationFactory: IAppNavigationFactory,
    private val comicsViewModel: ComicsViewModel
) : IAppPage {

    @Composable
    override operator fun invoke() {
        val comics = comicsViewModel.comics.observeAsState()
        Column(
            Modifier
                .fillMaxHeight()
                .background(Brown),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Box(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .weight(1f, true)
                    .fillMaxWidth()
            ) {

            }

            PrimaryButton(
                text = stringResource(id = R.string.back),
                modifier = Modifier
                    .padding(vertical = 5.dp)
                    .width(200.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                appNavigationFactory.back()
            }
        }
    }

}