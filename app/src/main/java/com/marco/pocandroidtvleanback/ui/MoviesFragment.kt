package com.marco.pocandroidtvleanback.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.marco.pocandroidtvleanback.databinding.FragmentMoviesBinding
import com.marco.pocandroidtvleanback.utils.viewInflateBinding


class MoviesFragment : Fragment() {
    private val binding by viewInflateBinding(FragmentMoviesBinding::inflate)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = binding.root

}