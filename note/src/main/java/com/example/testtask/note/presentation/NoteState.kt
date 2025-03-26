package com.example.testtask.note.presentation

data class NoteState(
    val isLoading: Boolean = true,
    val data: NoteData = NoteData(),
    val error: String? = null,
)

data class NoteData(
    val id: String = "",
    val title: String = "",
    val body: String = "",
)