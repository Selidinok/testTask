package com.example.testtask.api.domain

import com.example.testtask.api.domain.entities.Note
import com.example.testtask.api.domain.entities.NoteCreationRequest

interface NotesRepository {
    suspend fun getNotes(): List<Note>
    suspend fun getNote(id: String): Note
    suspend fun createNote(request: NoteCreationRequest): Note
    suspend fun updateNote(note: Note): Note
}