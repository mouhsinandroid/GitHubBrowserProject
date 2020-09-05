package com.mouhsinbr.android.githubbrowserproject.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.mouhsinbr.android.githubbrowserproject.githubapi.GitHubApi
import com.mouhsinbr.android.githubbrowserproject.githubapi.model.RepoApiModel
import com.mouhsinbr.android.githubbrowserproject.githubapi.model.UserApiModel
import com.mouhsinbr.android.githubbrowserproject.home.list.RepoItem
import com.mouhsinbr.android.repository.AppRepository
import org.junit.Before

import org.junit.Rule
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

class HomeViewModelTest {

    @get:Rule val taskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: HomeViewModel
    private lateinit var viewStatValues: MutableList<HomeViewState>

    @Before
    fun setUp() {
        val appRepository = AppRepository(FakeGitHubApi())

        viewStatValues = mutableListOf()

        viewModel = HomeViewModel(appRepository)
        viewModel.viewStateUpdate.observeForever { viewStatValues.add(it) }
    }

    @Test
    fun `loaded state contains repo models`() {
        assertThat(viewStatValues.size).isEqualTo(1)

        val expectedState = HomeViewStateLoaded(
            repo = listOf(
                RepoItem(
                    name = fakeRepoApiModel.name,
                    description = fakeRepoApiModel.description,
                    starsCount = fakeRepoApiModel.stargazersCount,
                    forksCount = fakeRepoApiModel.forksCount,


                )
            )
        )

     assertThat(viewStatValues[0]).isEqualTo(expectedState)


    }


}

private class FakeGitHubApi: GitHubApi {
    override fun getTopRepositories(): List<RepoApiModel> {
        return  listOf(fakeRepoApiModel)
    }

}