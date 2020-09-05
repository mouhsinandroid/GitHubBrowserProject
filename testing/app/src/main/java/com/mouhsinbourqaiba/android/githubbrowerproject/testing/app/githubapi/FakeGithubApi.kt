package com.mouhsinbourqaiba.android.githubbrowerproject.testing.app.githubapi

import com.mouhsinbr.android.githubbrowserproject.githubapi.GitHubApi
import com.mouhsinbr.android.githubbrowserproject.githubapi.model.RepoApiModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FakeGithubApi @Inject constructor(): GitHubApi {

    var repos = listOf<RepoApiModel>()

    override fun getTopRepositories(): List<RepoApiModel> {
        return repos
    }
}