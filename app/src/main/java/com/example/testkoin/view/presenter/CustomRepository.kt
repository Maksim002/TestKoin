package com.example.testkoin.view.presenter

import com.example.testkoin.modelRepository.BaseRepository

class CustomRepository() : BaseRepository {
    override fun giveInt(): String {
       return "Можно одновременно объявить переменную и определить массив (в основном так и делают):"
    }

    override fun getHello(): String {
        return "Последнее правило может запутать начинающего программиста, который забудет, что строка типа String является объектом."
    }
}