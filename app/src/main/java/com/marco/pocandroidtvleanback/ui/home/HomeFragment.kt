package com.marco.pocandroidtvleanback.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import com.bumptech.glide.Glide
import com.marco.pocandroidtvleanback.R
import com.marco.pocandroidtvleanback.data_remote.exception.InvalidApiKeyException
import com.marco.pocandroidtvleanback.databinding.FragmentHomeBinding
import com.marco.pocandroidtvleanback.domain.model.movies.Result
import com.marco.pocandroidtvleanback.presentation.HomeViewModel
import com.marco.pocandroidtvleanback.domain.utils.Constants
import com.marco.pocandroidtvleanback.core.commons.extensions.isError
import com.marco.pocandroidtvleanback.core.commons.extensions.isSuccess
import com.marco.pocandroidtvleanback.core.commons.extensions.observeLiveData
import com.marco.pocandroidtvleanback.core.commons.utils.viewInflateBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private val binding by viewInflateBinding(FragmentHomeBinding::inflate)
    private lateinit var homeMovieListFragment: HomeMovieListFragment

    private val viewModel: HomeViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = binding.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addObservers(viewLifecycleOwner)
        init()
    }

    private fun addObservers(owner: LifecycleOwner) {
        viewModel.getNowPlayingMoviesViewState.observeLiveData(owner, false) {
            when {
                it.isSuccess() -> {
                    homeMovieListFragment.bindData(it.data, Constants.Movies.NOW_PLAYING)
                }

                it.isError() -> {
                    when (it.error) {
                        is InvalidApiKeyException -> {
                            Toast.makeText(
                                requireContext(),
                                "Please add A valid ApiKey",
                                Toast.LENGTH_LONG
                            ).show()
                        }

                        else -> {
                            Toast.makeText(
                                requireContext(),
                                "Generic error.",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
            }
        }

        viewModel.getPopularMoviesViewState.observeLiveData(owner, false) {
            when {
                it.isSuccess() -> {
                    homeMovieListFragment.bindData(it.data, Constants.Movies.POPULAR)
                }

                it.isError() -> {
                    when (it.error) {
                        is InvalidApiKeyException -> {
                            Toast.makeText(
                                requireContext(),
                                "Please add A valid ApiKey",
                                Toast.LENGTH_LONG
                            ).show()
                        }

                        else -> {
                            Toast.makeText(
                                requireContext(),
                                "Generic error.",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
            }
        }

        viewModel.getTopRatedMoviesViewState.observeLiveData(owner, false) {
            when {
                it.isSuccess() -> {
                    homeMovieListFragment.bindData(it.data, Constants.Movies.TOP_RATED)
                }

                it.isError() -> {
                    when (it.error) {
                        is InvalidApiKeyException -> {
                            Toast.makeText(
                                requireContext(),
                                "Please add A valid ApiKey",
                                Toast.LENGTH_LONG
                            ).show()
                        }

                        else -> {
                            Toast.makeText(
                                requireContext(),
                                "Generic error.",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
            }
        }

        viewModel.getUpcomingMoviesViewState.observeLiveData(owner, false) {
            when {
                it.isSuccess() -> {
                    homeMovieListFragment.bindData(it.data, Constants.Movies.UPCOMING)
                }

                it.isError() -> {
                    when (it.error) {
                        is InvalidApiKeyException -> {
                            Toast.makeText(
                                requireContext(),
                                "Please add A valid ApiKey",
                                Toast.LENGTH_LONG
                            ).show()
                        }

                        else -> {
                            Toast.makeText(
                                requireContext(),
                                "Generic error.",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
            }
        }
    }

    private fun init() {
        homeMovieListFragment = HomeMovieListFragment()
        val transaction = childFragmentManager.beginTransaction()
        transaction.add(R.id.list_fragment, homeMovieListFragment)
        transaction.commit()

        homeMovieListFragment.setOnContentSelectedListener { result ->
            updateBanner(result)
        }
        homeMovieListFragment.setOnItemClickListener {
            Toast.makeText(requireContext(), "OnClick ${it.title}", Toast.LENGTH_SHORT).show()
        }

        viewModel.getNowPlayingMovies()
        viewModel.getPopularMovies()
        viewModel.getTopRatedMovies()
        viewModel.getUpcomingMovies()
    }

    private fun updateBanner(dataList: Result) {
        binding.title.text = dataList.title
        binding.description.text = dataList.overview
        val url = Constants.BaseImageUrl + dataList.backdropPath
        Glide.with(this).load(url).into(binding.ivBanner)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.clearViewStates()
    }
}