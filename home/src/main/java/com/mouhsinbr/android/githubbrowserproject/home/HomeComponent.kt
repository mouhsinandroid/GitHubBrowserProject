package com.mouhsinbr.android.githubbrowserproject.home

import com.mouhsinbr.android.githubbrowserproject.appdeps.ApplicationDeps
import com.mouhsinbr.android.githubbrowserproject.appdeps.applicationDeps
import com.mouhsinbr.android.githubbrowserproject.di.component.getComponent
import com.mouhsinbr.android.githubbrowserproject.di.scope.ScreenScope
import com.mouhsinbr.android.githubbrowserproject.home.list.HomeModule
import dagger.Component

@ScreenScope
@Component(dependencies = [ApplicationDeps::class], modules = [HomeModule::class])
interface HomeComponent {

    fun inject(homeFragment: HomeFragment)

    @Component.Factory
    interface Factory {

        fun create(applicationDeps: ApplicationDeps): HomeComponent
    }
}

fun HomeFragment.inject() {

    getComponent {
        DaggerHomeComponent.factory().
        create(requireContext().applicationDeps())
    }.inject(this)
}