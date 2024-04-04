package app.lhmako.ui.pages.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.lhmako.ui.R
import app.lhmako.ui.guideline.buttons.PrimaryButton
import app.lhmako.ui.guideline.theme.Brown
import app.lhmako.ui.guideline.theme.Yellow
import app.lhmako.ui.library.navigation.factory.IAppNavigationFactory
import app.lhmako.ui.library.pages.AppRoute
import app.lhmako.ui.library.pages.IAppPage

class OnboardingPage(
    override val route: AppRoute = AppRoute.ONBOARDING,
    override val appNavigationFactory: IAppNavigationFactory
) : IAppPage {

    @Composable
    override operator fun invoke() {
        Column(
            Modifier
                .fillMaxHeight()
                .background(Brown),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Box(
                modifier = Modifier
                    .weight(1f, true)
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    color = Color.White,
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    lineHeight = 50.sp,
                    modifier = Modifier
                        .align(alignment = Alignment.Center)
                        .padding(horizontal = 24.dp)
                )
            }

            PrimaryButton(
                text = stringResource(id = R.string.start),
                modifier = Modifier
                    .padding(vertical = 5.dp)
                    .width(200.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                appNavigationFactory.navigateToComics()
            }
        }
    }
}
