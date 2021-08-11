package com.example.testkoin.modelRepository

import androidx.lifecycle.LiveData
import com.beksar.testnotification.service.result.ExampleModel
import com.timelysoft.tsjdomcom.service.ResultStatus

interface BaseRepository {
    fun requestCountryDetails() : LiveData<ResultStatus<ExampleModel>>
}