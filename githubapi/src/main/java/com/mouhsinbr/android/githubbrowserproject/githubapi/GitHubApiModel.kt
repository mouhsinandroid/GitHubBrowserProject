package com.mouhsinbr.android.githubbrowserproject.githubapi

import dagger.Binds
import dagger.Module

@Module
interface GitHubApiModel {

    @Binds
    fun  bindGitHubApi(mockGitHubApi: MockGitHubApi) : GitHubApi
}