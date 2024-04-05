package app.lhmako.ui.scenarios

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import app.lhmako.ui.adpaters.IAppResourcesAdapter
import app.lhmako.ui.adpaters.IApplicationAdapter
import app.lhmako.ui.guideline.theme.SuperHeroCardTheme
import app.lhmako.ui.guideline.theme.Yellow
import app.lhmako.ui.library.activities.AppActivity
import app.lhmako.ui.library.navigation.AppNavHost
import app.lhmako.ui.library.navigation.factory.IAppNavigationFactory
import app.lhmako.ui.library.navigation.factory.imp.AppNavigation
import app.lhmako.ui.library.pages.AppPageFactory

class MainActivity : AppActivity() {

    private val appResources: IAppResourcesAdapter by lazy {
        (application as IApplicationAdapter).appResources
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SuperHeroCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Yellow),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val appNavigationFactory: IAppNavigationFactory = AppNavigation(navController)
                    val pageFactory = AppPageFactory(appNavigationFactory, appResources)
                    AppNavHost(
                        navController = navController,
                        pageFactory = pageFactory,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }

}
