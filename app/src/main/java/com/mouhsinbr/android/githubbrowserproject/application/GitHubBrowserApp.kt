package com.mouhsinbr.android.githubbrowserproject.application

import android.app.Application
import com.mouhsinbr.android.githubbrowserproject.appdeps.ApplicationDeps
import com.mouhsinbr.android.githubbrowserproject.appdeps.HasApplicationDeps

class GitHubBrowserApp: Application(), HasApplicationDeps {
    private val appComponent by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override fun getApplicationDeps(): ApplicationDeps {
        return appComponent
    }
}