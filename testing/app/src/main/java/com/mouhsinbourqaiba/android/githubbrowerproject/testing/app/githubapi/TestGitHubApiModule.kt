package com.mouhsinbourqaiba.android.githubbrowerproject.testing.app.githubapi

import com.mouhsinbr.android.githubbrowserproject.githubapi.GitHubApi
import dagger.Binds
import dagger.Module

@Module
interface TestGitHubApiModule {

    @Binds
    fun bindGitHubApi(fakeGithubApi: FakeGithubApi): GitHubApi
}