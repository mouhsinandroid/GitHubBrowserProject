package com.mouhsinbr.android.githubbrowserproject.application

import android.app.Application

class GitHubBrowserApp: Application() {
    private val appComponent by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}