package com.example.testtask.api.data

import com.example.testtask.api.data.api.NotesApi
import com.example.testtask.api.data.mapper.toNote
import com.example.testtask.api.data.mapper.toNotes
import com.example.testtask.api.domain.NotesRepository
import com.example.testtask.api.domain.entities.Note
import com.example.testtask.api.domain.entities.NoteCreationRequest
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NotesRepositoryImpl @Inject constructor(
    private val api: NotesApi,
    private val dispatcher: CoroutineDispatcher,
) : NotesRepository {

    override suspend fun getNotes(): List<Note> = withContext(dispatcher) {
        api.getNotes().toNotes()
    }

    override suspend fun getNote(id: String): Note = withContext(dispatcher) {
        api.getNote(id).toNote()
    }

    override suspend fun createNote(request: NoteCreationRequest): Note = withContext(dispatcher) {
        api.createNote(request).toNote()
    }

    override suspend fun updateNote(note: Note): Note = withContext(dispatcher) {
        api.updateNote(note).toNote()
    }
}
