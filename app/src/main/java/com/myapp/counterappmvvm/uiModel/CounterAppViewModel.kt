package com.myapp.counterappmvvm.uiModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CounterAppViewModel : ViewModel() {
    //Use the TAG variable for logging (LOGCAT)
    private val TAG = "CounterAppViewModel"
    // Declare the variable counter as private so that no other user from outside can access it.
    private var counter = 0
   // backing property for uiState
    //It is a flow to emit counter values
    private val _uiState: MutableStateFlow<Int> = MutableStateFlow(counter)
    // It is a flow to be collected for receiving counter values.
    //asStateFlow is use to create readOnly version of state flow
    val uiState: StateFlow<Int> = _uiState.asStateFlow()


    fun increment() {

        counter++
        Log.i(TAG, "increment: $counter")

        _uiState.value = counter
    }

    fun decrement() {
        counter--
        Log.i(TAG, "decrement:$counter")

        _uiState.value = counter
    }
}