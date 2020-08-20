package com.mouhsinbr.android.repository

import com.google.common.truth.Truth.assertThat
import com.mouhsinbr.android.githubbrowserproject.githubapi.GitHubApi
import com.mouhsinbr.android.githubbrowserproject.githubapi.model.RepoApiModel
import com.mouhsinbr.android.githubbrowserproject.githubapi.model.UserApiModel
import org.junit.Before
import org.junit.Test

private val fakeRepoApiModel =  RepoApiModel(
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

class AppRepositoryTest {

    private lateinit var appRepository: AppRepository
    private val fakeGitHubApi = FakeGitHubApi()

    @Before
    fun setUp() {
        appRepository = AppRepository(fakeGitHubApi)
    }

    @Test
    fun successfulQuery() {
        val topRepo = appRepository.getTopRepos()

        assertThat(topRepo.size).isEqualTo(1)
        assertThat(topRepo[0]).isEqualTo(fakeRepoApiModel)
    }

}

private class FakeGitHubApi: GitHubApi {
    override fun getTopRepositories(): List<RepoApiModel> {
        return  listOf(fakeRepoApiModel)
    }

}