package com.marco.pocandroidtvleanback.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import com.marco.pocandroidtvleanback.ListFragment
import com.marco.pocandroidtvleanback.R
import com.marco.pocandroidtvleanback.data_remote.exception.InvalidApiKeyException
import com.marco.pocandroidtvleanback.databinding.FragmentHomeBinding
import com.marco.pocandroidtvleanback.presentation.HomeViewModel
import com.marco.pocandroidtvleanback.utils.Constants
import com.marco.pocandroidtvleanback.utils.isError
import com.marco.pocandroidtvleanback.utils.isSuccess
import com.marco.pocandroidtvleanback.utils.observeLiveData
import com.marco.pocandroidtvleanback.utils.viewInflateBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private val binding by viewInflateBinding(FragmentHomeBinding::inflate)
    private lateinit var listFragment: ListFragment

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
                    listFragment.bindData(it.data, Constants.Movies.NOW_PLAYING)
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
                    listFragment.bindData(it.data, Constants.Movies.POPULAR)
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
                    listFragment.bindData(it.data, Constants.Movies.TOP_RATED)
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
                    listFragment.bindData(it.data, Constants.Movies.UPCOMING)
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
        listFragment = ListFragment()
        val transaction = childFragmentManager.beginTransaction()
        transaction.add(R.id.list_fragment, listFragment)
        transaction.commit()

        viewModel.getNowPlayingMovies()
        viewModel.getPopularMovies()
        viewModel.getTopRatedMovies()
        viewModel.getUpcomingMovies()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.clearViewStates()
    }
}