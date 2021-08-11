package com.example.testkoin.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.testkoin.R
import com.example.testkoin.view.viewMode.MainDogModel
import com.example.testkoin.view.viewMode.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel : MainViewModel by viewModel()
    private val mainDogModel : MainDogModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.getStringValue().observe(this, Observer {
            text_name.text = it
        })

        mainDogModel.getStringValue().observe(this, Observer {
            text_name1.text = it
        })
    }
}