package com.develou.compose_estado.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.develou.compose_estado.toDoubleOrZero

class SumViewModel : ViewModel() {

    private val _number1 = MutableLiveData("")
    val number1: LiveData<String> = _number1

    private val _number2 = MutableLiveData("")
    val number2: LiveData<String> = _number2

    private val _sum = MutableLiveData(0.0)
    val sum: LiveData<Double> = _sum

    fun onFirstNumberChange(number: String) {
        _number1.value = number
    }

    fun onSecondNumberChange(number: String) {
        _number2.value = number
    }

    fun onCalculate() {
        _sum.value = number1.value.toDoubleOrZero() + number2.value.toDoubleOrZero()
    }
}
