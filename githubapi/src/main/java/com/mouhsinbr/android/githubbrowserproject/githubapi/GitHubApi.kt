package com.mouhsinbr.android.githubbrowserproject.githubapi

import com.mouhsinbr.android.githubbrowserproject.githubapi.model.RepoApiModel
import com.mouhsinbr.android.githubbrowserproject.githubapi.model.UserApiModel
import javax.inject.Inject
import javax.inject.Singleton

interface GitHubApi {

    fun getTopRepositories() : List<RepoApiModel>
}

@Singleton
class MockGitHubApi @Inject constructor(): GitHubApi {
    override fun getTopRepositories(): List<RepoApiModel> {
        return listOf(
            RepoApiModel(
                id= 1L,
                name = "Mock Repo",
                description = "Mock repo description",
                owner = UserApiModel(1L, "dagger"),
                stargazersCount = 1,
                forksCount = 1,
                contributorsUrl = "",
                createdDate = "1/1/2020",
                updateDate = "1/1/2020"
            ),
            RepoApiModel(
                id= 1L,
                name = "Mock Repo",
                description = "Mock repo description",
                owner = UserApiModel(1L, "dagger"),
                stargazersCount = 1,
                forksCount = 1,
                contributorsUrl = "",
                createdDate = "1/1/2020",
                updateDate = "1/1/2020"
            ),
            RepoApiModel(
                id= 1L,
                name = "Mock Repo",
                description = "Mock repo description",
                owner = UserApiModel(1L, "dagger"),
                stargazersCount = 1,
                forksCount = 1,
                contributorsUrl = "",
                createdDate = "1/1/2020",
                updateDate = "1/1/2020"
            ),
            RepoApiModel(
                id= 1L,
                name = "Mock Repo",
                description = "Mock repo description",
                owner = UserApiModel(1L, "dagger"),
                stargazersCount = 1,
                forksCount = 1,
                contributorsUrl = "",
                createdDate = "1/1/2020",
                updateDate = "1/1/2020"
            ),
            RepoApiModel(
                id= 1L,
                name = "Mock Repo",
                description = "Mock repo description",
                owner = UserApiModel(1L, "dagger"),
                stargazersCount = 1,
                forksCount = 1,
                contributorsUrl = "",
                createdDate = "1/1/2020",
                updateDate = "1/1/2020"
            )
        )
    }

}