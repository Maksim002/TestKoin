package com.example.testkoin.di

import com.example.testkoin.repository.CustomRepository
import com.example.testkoin.modelRepository.BaseRepository
import com.example.testkoin.main.MainDogModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object ApplicationModule {
    val applicationModule : Module = module {

        single<BaseRepository> {
            CustomRepository(get())
        }

        viewModel {
            MainDogModel()
        }
    }
}
