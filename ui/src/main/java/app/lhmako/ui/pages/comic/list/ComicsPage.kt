package app.lhmako.ui.pages.comic.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import app.lhmako.ui.pages.comic.list.viewmodel.ComicsViewModel
import coil.compose.AsyncImage

class ComicsPage(
    override val route: AppRoute = AppRoute.COMICS,
    override val appNavigationFactory: IAppNavigationFactory,
    private val comicsViewModel: ComicsViewModel
) : IAppPage {

    @Composable
    override operator fun invoke(backStackEntry: NavBackStackEntry) {
        val comics = comicsViewModel.comics.observeAsState(arrayListOf())
        val error = comicsViewModel.error.observeAsState(Throwable())
        Column(
            Modifier
                .fillMaxHeight()
                .background(Brown),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            LazyColumn(
                modifier = Modifier
                    .weight(1f, true)
            ) {
                this.items(comics.value) { item: ComicDTO ->
                    ComicCard(comicDTO = item)
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

    @Composable
    fun ComicCard(comicDTO: ComicDTO) {
        Card(
            modifier = Modifier.padding(8.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            onClick = {
                appNavigationFactory.navigateToComic(comicDTO.id)
            }
        ) {
            Column {
                AsyncImage(
                    model = comicDTO.imageUrl,
                    contentDescription = comicDTO.description,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(194.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = comicDTO.title,
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }

}