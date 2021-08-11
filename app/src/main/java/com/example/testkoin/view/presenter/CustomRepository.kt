package com.example.testkoin.view.presenter

import com.example.testkoin.modelRepository.BaseRepository

class CustomRepository() : BaseRepository {
    override fun giveInt(): String {
       return "wdwdwd"
    }

    override fun getHello(): String {
        return "vfyuj"
    }
}