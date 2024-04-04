package app.lhmako.ui.pages.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
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
            Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .weight(1f, false)
            ) {

            }

            Button(
                onClick = {
                    appNavigationFactory.navigateToComics()
                },
                modifier = Modifier
                    .padding(vertical = 2.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Continue", color = Color.Red)
            }
        }
    }
}
