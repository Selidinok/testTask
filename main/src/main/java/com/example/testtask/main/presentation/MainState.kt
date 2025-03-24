package com.example.testtask.main.presentation

data class MainState(
    val isLoading: Boolean = true,
    val notes: List<NoteState> = emptyList(),
    val error: String? = null,
)

data class NoteState(
    val id: String,
    val title: String,
    val body: String,
)
