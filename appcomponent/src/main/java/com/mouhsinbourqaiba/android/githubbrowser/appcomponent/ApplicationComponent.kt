package com.mouhsinbourqaiba.android.githubbrowser.appcomponent

import android.content.Context
import com.mouhsinbr.android.githubbrowserproject.appdeps.ApplicationDeps
import com.mouhsinbr.android.githubbrowserproject.githubapi.GitHubApi
import com.mouhsinbr.android.githubbrowserproject.githubapi.GitHubApiModel
import com.mouhsinbr.android.repository.AppRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [GitHubApiModel::class])
interface ApplicationComponent: ApplicationDeps {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent

    }
}