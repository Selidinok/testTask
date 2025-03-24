package com.example.testtask.main.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtask.main.domain.MainInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val interactor: MainInteractor,
) : ViewModel() {

    private val _state = MutableStateFlow(MainState())
    val state = _state.asStateFlow()

    fun onEnterScreen() {
        viewModelScope.launch {
            try {
                val data = interactor.getNoteState()
                _state.update { it.copy(isLoading = false, notes = data, error = null) }
            } catch (exception: Exception) {
                _state.update { it.copy(isLoading = false, error = exception.message) }
            }
        }
    }

    fun onSwipe() {
        _state.update { it.copy(isLoading = true) }
        onEnterScreen()
    }

    fun onRefresh() {
        onEnterScreen()
    }
}