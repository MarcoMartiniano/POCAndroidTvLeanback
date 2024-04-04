package com.marco.pocandroidtvleanback.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.marco.pocandroidtvleanback.databinding.FragmentSportsBinding
import com.marco.pocandroidtvleanback.core.commons.utils.viewInflateBinding

class SportsFragment : Fragment() {
    private val binding by viewInflateBinding(FragmentSportsBinding::inflate)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = binding.root

}