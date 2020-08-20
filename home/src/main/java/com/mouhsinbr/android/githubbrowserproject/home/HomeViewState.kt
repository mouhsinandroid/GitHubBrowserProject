package com.mouhsinbr.android.githubbrowserproject.home

import com.mouhsinbr.android.githubbrowserproject.home.list.RepoItem

sealed class HomeViewState
object HomeViewStateLoading: HomeViewState()
data class HomeViewStateLoaded(val repo: List<RepoItem>): HomeViewState()
data class HomeViewStateError(val message: String): HomeViewState()