package com.example.testtask.create.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class CreateViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(CreateState())
    val state = _state.asStateFlow()

    fun onEnterScreen() {
        _state.update { it.copy(title = "Title", body = "Body") }
    }

    fun onTitleChange(text: String) {
        _state.update { it.copy(title = text) }
    }

    fun onBodyChange(text: String) {
        _state.update { it.copy(body = text) }
    }
}