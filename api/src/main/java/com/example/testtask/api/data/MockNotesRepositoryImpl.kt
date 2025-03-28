package com.example.testtask.api.data

import com.example.testtask.api.data.mapper.toNote
import com.example.testtask.api.data.mapper.toNotes
import com.example.testtask.api.domain.NotesRepository
import com.example.testtask.api.domain.entities.Note
import com.example.testtask.api.domain.entities.NoteCreationRequest
import kotlinx.coroutines.delay
import javax.inject.Inject

class MockNotesRepositoryImpl @Inject constructor() : NotesRepository {

    override suspend fun getNotes(): List<Note> {
        delay(500)
        return NotesMock.notesResponse.toNotes()
    }

    override suspend fun getNote(id: String): Note {
        delay(500)
        return NotesMock.note.toNote()
    }

    override suspend fun createNote(request: NoteCreationRequest): Note {
        delay(500)
        return NotesMock.note.toNote()
    }

    override suspend fun updateNote(note: Note): Note {
        delay(500)
        return NotesMock.note.toNote()
    }
}
