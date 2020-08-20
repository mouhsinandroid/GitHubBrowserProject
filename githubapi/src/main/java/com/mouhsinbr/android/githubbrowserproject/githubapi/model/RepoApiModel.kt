package com.mouhsinbr.android.githubbrowserproject.githubapi.model

data class RepoApiModel (
    val id: Long,
    val name: String,
    val description: String,
    val owner : UserApiModel,
    val stargazersCount: Int,
    val forksCount: Int,
    val contributorsUrl: String,
    val createdDate: String,
    val updateDate: String
)