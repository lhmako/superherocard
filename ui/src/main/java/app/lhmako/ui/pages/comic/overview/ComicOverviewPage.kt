package app.lhmako.ui.pages.comic.overview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import app.lhmako.ui.R
import app.lhmako.ui.dto.ComicDTO
import app.lhmako.ui.guideline.buttons.PrimaryButton
import app.lhmako.ui.guideline.theme.Brown
import app.lhmako.ui.library.navigation.factory.IAppNavigationFactory
import app.lhmako.ui.library.pages.AppRoute
import app.lhmako.ui.library.pages.IAppPage
import app.lhmako.ui.pages.comic.overview.viewmodel.ComicViewModel
import coil.compose.AsyncImage

class ComicOverviewPage(
    override val route: AppRoute = AppRoute.COMIC,
    override val appNavigationFactory: IAppNavigationFactory,
    private val viewModel: ComicViewModel
) : IAppPage {

    @Composable
    override operator fun invoke(backStackEntry: NavBackStackEntry) {
        backStackEntry.arguments?.getString("id")?.let { viewModel.loadComic(it) }

        val comicDTO = viewModel.comic.observeAsState(ComicDTO("", "", "", ""))
        Column(
            Modifier
                .fillMaxHeight()
                .background(Brown),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                modifier = Modifier
                    .weight(1f, true)
                    .fillMaxWidth()
            ) {
                Column {
                    AsyncImage(
                        model = comicDTO.value.imageUrl,
                        contentDescription = comicDTO.value.description,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(194.dp),
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = comicDTO.value.title,
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.titleMedium
                    )
                }
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