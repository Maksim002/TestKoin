package com.example.testkoin.view.viewMode

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testkoin.modelRepository.BaseRepository
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.lang.Exception

class MainDogModel: ViewModel(), KoinComponent {

    private val baseRep : BaseRepository by inject()
    private val hello: MutableLiveData<String> by lazy(LazyThreadSafetyMode.NONE, initializer = { MutableLiveData<String>() } )

    fun getStringValue(): LiveData<String> {
        try {
            hello.setValue(baseRep.giveInt())
        }catch (e: Exception){
            e.printStackTrace()
        }
        return hello
    }
}