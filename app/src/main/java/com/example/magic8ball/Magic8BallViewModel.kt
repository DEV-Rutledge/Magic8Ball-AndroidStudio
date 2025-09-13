package com.example.magic8ball

import android.app.Application
import androidx.annotation.StringRes
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData



class Magic8BallViewModel(application: Application) : AndroidViewModel(application) {

    private val _response = MutableLiveData<String>()
    val response: LiveData<String> get() = _response

    private val responses = listOf(
        Response(R.string.response_1),
        Response(R.string.response_2),
        Response(R.string.response_3),
        Response(R.string.response_4),
        Response(R.string.response_5),
        Response(R.string.response_6),
        Response(R.string.response_7),
        Response(R.string.response_8)
    )

    fun getRandomResponse() {
        val randomResponse = responses.random()
        _response.value = getApplication<Application>().getString(randomResponse.textResId)
    }
}
