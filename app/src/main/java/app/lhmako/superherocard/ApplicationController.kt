package app.lhmako.superherocard

import android.app.Application
import app.lhmako.superherocard.adapters.AppResourcesAdapter
import app.lhmako.ui.adpaters.IAppResourcesAdapter
import app.lhmako.ui.adpaters.IApplicationAdapter

class ApplicationController : Application(), IApplicationAdapter {
    private val appDependencies by lazy { AppDependencies(context = applicationContext) }
    override val appResources: IAppResourcesAdapter by lazy { AppResourcesAdapter(appDependencies) }
}