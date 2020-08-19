package com.mouhsinbr.android.githubbrowserproject.application

import android.content.Context
import com.mouhsinbr.android.githubbrowserproject.githubapi.GitHubApi
import com.mouhsinbr.android.githubbrowserproject.githubapi.GitHubApiModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [GitHubApiModel::class])
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context):ApplicationComponent

    }
}