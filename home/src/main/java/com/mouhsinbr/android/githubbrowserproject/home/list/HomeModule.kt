package com.mouhsinbr.android.githubbrowserproject.home.list

import androidx.lifecycle.ViewModel
import com.mouhsinbr.android.githubbrowserproject.di.viewmodel.ViewModelKey
import com.mouhsinbr.android.githubbrowserproject.home.HomeViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class HomeModule {

    @Provides
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun bindViewModel(homeViewModel: HomeViewModel) : ViewModel {
        return homeViewModel
    }

}