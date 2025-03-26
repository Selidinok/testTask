package com.example.testtask.note.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtask.note.domain.NoteInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val interactor: NoteInteractor,
) : ViewModel() {

    private val _state = MutableStateFlow(NoteState())
    val state = _state.asStateFlow()

    fun onRefresh(id: String = _state.value.data.id) {
        viewModelScope.launch {
            try {
                val data = interactor.getNote(id = id)
                _state.update { it.copy(isLoading = false, data = data, error = null) }
            } catch (exception: Exception) {
                _state.update { it.copy(isLoading = false, error = exception.message) }
            }
        }
    }
}