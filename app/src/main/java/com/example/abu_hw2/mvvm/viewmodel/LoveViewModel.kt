package com.example.abu_hw2.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.abu_hw2.data.LoveResult
import com.example.abu_hw2.mvvm.repository.LoveRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor(
    private val repository: LoveRepository
) : ViewModel() {

    fun getLoveResult(firstName: String, secondName: String): LiveData<LoveResult> {
        return repository.getLoveResult(firstName, secondName)
    }
}