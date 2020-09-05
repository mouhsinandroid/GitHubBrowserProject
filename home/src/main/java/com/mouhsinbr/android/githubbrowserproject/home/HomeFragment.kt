package com.mouhsinbr.android.githubbrowserproject.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mouhsinbr.android.githubbrowserproject.di.viewmodel.AppViewModelFactory
import com.mouhsinbr.android.githubbrowserproject.home.databinding.ScreenHomeBinding
import com.mouhsinbr.android.githubbrowserproject.home.list.HomeRepoAdapter
import javax.inject.Inject

class HomeFragment: Fragment() {

    @Inject lateinit var appViewModelFactory : AppViewModelFactory

    private val homeViewModel: HomeViewModel by lazy {
        ViewModelProvider(this, appViewModelFactory)[HomeViewModel::class.java]
    }

    override fun onAttach(context: Context) {
        inject()
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = ScreenHomeBinding.inflate(inflater, container, false)

        binding.repoList.apply {
            adapter = HomeRepoAdapter()
            layoutManager = LinearLayoutManager(context)

            addItemDecoration(
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            )
        }

        homeViewModel.viewStateUpdate.observe(this, Observer { state ->
            when(state) {
                is HomeViewStateLoading -> handleLoadingState(binding)
                is HomeViewStateLoaded -> handleLoadedState(state, binding)
                is HomeViewStateError -> handleErrorState(state, binding)
            }

        })
        return binding.root
    }

    private fun handleErrorState(state: HomeViewStateError, binding: ScreenHomeBinding) {
        binding.loadingIndicator.visibility = View.GONE
        binding.repoList.visibility = View.GONE

        binding.errorTextView.visibility = View.VISIBLE
        binding.errorTextView.text = state.message


    }

    private fun handleLoadedState(state: HomeViewStateLoaded, binding: ScreenHomeBinding) {
        binding.errorTextView.visibility = View.GONE
        binding.loadingIndicator.visibility = View.GONE

        binding.repoList.visibility = View.VISIBLE
        (binding.repoList.adapter as HomeRepoAdapter).setRepoItem(state.repo)


    }


    private fun handleLoadingState(binding: ScreenHomeBinding) {
        binding.repoList.visibility = View.GONE
        binding.errorTextView.visibility = View.GONE
        binding.loadingIndicator.visibility = View.VISIBLE

    }
}