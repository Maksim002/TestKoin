package com.example.testkoin.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.testkoin.model.ExampleModel
import com.example.testkoin.modelRepository.BaseRepository
import com.example.testkoin.repository.CustomRepository
import com.timelysoft.tsjdomcom.service.ResultStatus
import org.koin.core.KoinComponent
import org.koin.core.inject
import org.koin.ext.scope

class MainDogModel(): ViewModel(), KoinComponent {


    private val baseRep : BaseRepository by inject()

    fun requestCountry() : LiveData<ResultStatus<ExampleModel>> {
        return baseRep.requestCountryDetails()
    }
}