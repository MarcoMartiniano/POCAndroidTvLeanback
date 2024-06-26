package com.marco.pocandroidtvleanback.core.di

import com.marco.pocandroidtvleanback.presentation.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { HomeViewModel() }
}