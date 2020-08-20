package com.mouhsinbr.android.repository

import com.mouhsinbr.android.githubbrowserproject.githubapi.GitHubApi
import com.mouhsinbr.android.githubbrowserproject.githubapi.model.RepoApiModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepository @Inject constructor(
    private val gitHubApi: GitHubApi
){
    fun getTopRepos(): List<RepoApiModel> {
        return gitHubApi.getTopRepositories()
    }
}