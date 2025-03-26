package com.example.testtask.create.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtask.create.domain.CreateInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateViewModel @Inject constructor(
    private val interactor: CreateInteractor,
) : ViewModel() {

    private val _state = MutableStateFlow(CreateState())
    val state = _state.asStateFlow()

    fun onRefresh(id: String? = _state.value.data.id) {
        if (id != null) {
            _state.update { it.copy(isLoading = true) }
            viewModelScope.launch {
                try {
                    val data = interactor.getNote(id)
                    _state.update { it.copy(isLoading = false, data = data, error = null) }
                } catch (exception: Exception) {
                    _state.update { it.copy(isLoading = false, error = exception.message) }
                }
            }
        } else {
            _state.update { it.copy(isLoading = false) }
        }
    }

    fun onTitleChange(text: String) {
        _state.update { it.copy(data = it.data.copy(title = text)) }
    }

    fun onBodyChange(text: String) {
        _state.update { it.copy(data = it.data.copy(body = text)) }
    }

    fun onSave() {
        _state.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            try {
                interactor.addNote(_state.value.data)
                _state.update { it.copy(isLoading = false, error = null) }
            } catch (exception: Exception) {
                _state.update { it.copy(isLoading = false, error = exception.message) }
            }
        }
    }
}