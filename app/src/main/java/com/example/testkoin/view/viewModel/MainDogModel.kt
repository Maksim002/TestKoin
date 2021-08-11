package com.example.testkoin.view.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.beksar.testnotification.service.result.ExampleModel
import com.example.testkoin.modelRepository.BaseRepository
import com.timelysoft.tsjdomcom.service.ResultStatus
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.lang.Exception

class MainDogModel: ViewModel(), KoinComponent {

    private val baseRep : BaseRepository by inject()

    fun requestCountry() : LiveData<ResultStatus<ExampleModel>> {
        return baseRep.requestCountryDetails()
    }
}