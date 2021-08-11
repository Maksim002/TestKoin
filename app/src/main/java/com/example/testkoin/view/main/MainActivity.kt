package com.example.testkoin.view.main

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.testkoin.R
import com.example.testkoin.view.viewModel.MainDogModel
import com.timelysoft.tsjdomcom.service.Status
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    private val mainDogModel : MainDogModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainDogModel.requestCountry().observe(this, Observer {
            val data = it.data
            val msg = it.msg
            when (it.status) {
                Status.SUCCESS -> {
                    var j = 0
                    val catNames = arrayOfNulls<String>(data!!.data!!.keys.size)
                    for (i in data.data!!.keys){
                        catNames[j++] = j.toString() + "." + " Код cтрана:  " + i
                        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, catNames)
                        list_items.setAdapter(adapter)
                    }
                }
                Status.NETWORK, Status.ERROR -> {
                    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}