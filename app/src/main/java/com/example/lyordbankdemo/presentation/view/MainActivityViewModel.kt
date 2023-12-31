package com.example.lyordbankdemo.presentation.view

import androidx.lifecycle.ViewModel
import com.cleanarchitectkotlinflowhiltsimplestway.utils.Utils
import com.example.lyordbankdemo.domain.SampleUseCase
import com.example.lyordbankdemo.presentation.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val sampleUseCase: SampleUseCase) :
    ViewModel() {

    fun getSampleResponse() = flow {
        emit(State.LoadingState)
        try {
            delay(1000)
            emit(State.DataState(sampleUseCase()))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(Utils.resolveError(e))
        }
    }
}