package com.mouhsinbourqaiba.android.githubbrowerproject.testing.app

import android.content.Context
import com.mouhsinbourqaiba.android.githubbrowerproject.testing.app.githubapi.FakeGithubApi
import com.mouhsinbourqaiba.android.githubbrowerproject.testing.app.githubapi.TestGitHubApiModule
import com.mouhsinbourqaiba.android.githubbrowser.appcomponent.ApplicationComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [TestGitHubApiModule::class])
interface TestApplicationComponent: ApplicationComponent {

    fun gitHubApi(): FakeGithubApi

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): TestApplicationComponent
    }

}