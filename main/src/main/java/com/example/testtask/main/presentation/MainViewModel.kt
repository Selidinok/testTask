package com.example.testtask.main.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class MainViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(MainState())
    val state = _state.asStateFlow()

    fun onEnterScreen() {
        _state.update { it.copy(notes = listOf("First", "Second", " Third")) }
    }
}