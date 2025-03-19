package com.example.testtask.note.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class NoteViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(NoteState())
    val state = _state.asStateFlow()

    fun onEnterScreen() {
        _state.update { it.copy(title = "Title", body = "Body") }
    }
}