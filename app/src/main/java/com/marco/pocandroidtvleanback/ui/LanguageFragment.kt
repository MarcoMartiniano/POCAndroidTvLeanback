package com.marco.pocandroidtvleanback.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.marco.pocandroidtvleanback.databinding.FragmentLanguageBinding
import com.marco.pocandroidtvleanback.core.commons.utils.viewInflateBinding

class LanguageFragment : Fragment() {
    private val binding by viewInflateBinding(FragmentLanguageBinding::inflate)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = binding.root

}