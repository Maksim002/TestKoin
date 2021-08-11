package com.example.testkoin.dependancy

import com.example.testkoin.view.presenter.CustomRepository
import com.example.testkoin.view.viewMode.MainViewModel
import com.example.testkoin.modelRepository.BaseRepository
import com.example.testkoin.view.viewMode.MainDogModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object ApplicationModule {
    val applicationModule : Module = module {

        single<BaseRepository> {
            provideCustomRepository()
        }

        viewModel {
            provideMainViewModel(get())
        }

        viewModel {
            provideMainDogViewModel(get())
        }
    }


    fun provideCustomRepository() : CustomRepository = CustomRepository()
    fun provideMainViewModel(baseRepository : BaseRepository) : MainViewModel = MainViewModel()
    fun provideMainDogViewModel(baseRepository : BaseRepository) : MainDogModel = MainDogModel()


}
