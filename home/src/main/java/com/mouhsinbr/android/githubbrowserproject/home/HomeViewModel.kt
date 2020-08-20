package com.mouhsinbr.android.githubbrowserproject.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mouhsinbr.android.githubbrowserproject.home.list.RepoItem
import com.mouhsinbr.android.repository.AppRepository
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val appRepository: AppRepository
) : ViewModel() {
    private val _viewState = MutableLiveData<HomeViewState>(HomeViewStateLoading)
    val viewStateUpdate : LiveData<HomeViewState> = _viewState

    init {
        val topRepo = appRepository.getTopRepos()
        _viewState.value = HomeViewStateLoaded(
            repo = topRepo.map {
                RepoItem(
                    name = it.name,
                    description = it.description,
                    starsCount = it.stargazersCount,
                    forksCount = it.forksCount
                )
            }
        )

    }
}
