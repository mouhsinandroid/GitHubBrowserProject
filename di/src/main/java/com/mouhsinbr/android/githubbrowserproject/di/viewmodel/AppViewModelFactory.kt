package com.mouhsinbr.android.githubbrowserproject.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.NullPointerException
import javax.inject.Inject
import javax.inject.Provider
import kotlin.jvm.Throws

class AppViewModelFactory @Inject constructor(
    private val classToViewModel: @JvmSuppressWildcards Map<Class<out ViewModel>, Provider<ViewModel>>
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED NAME")
        return classToViewModel[modelClass]?.get() as? T?:
        throw NullPointerException("no view model mapping for class: ${modelClass.name}")
    }
}