package com.example.testkoin.dependancy

import com.example.testkoin.servise.CustomRepository
import com.example.testkoin.modelRepository.BaseRepository
import com.example.testkoin.view.viewModel.MainDogModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object ApplicationModule {
    val applicationModule : Module = module {

        single<BaseRepository> {
            provideCustomRepository()
        }

        viewModel {
            provideMainDogViewModel()
        }
    }

    fun provideCustomRepository() : CustomRepository = CustomRepository()
    fun provideMainDogViewModel() : MainDogModel = MainDogModel()
}
