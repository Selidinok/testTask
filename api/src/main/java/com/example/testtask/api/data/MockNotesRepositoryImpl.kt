package com.example.testtask.api.data

import com.example.testtask.api.data.mapper.toNotes
import com.example.testtask.api.domain.NotesRepository
import com.example.testtask.api.domain.entities.Note
import kotlinx.coroutines.delay
import javax.inject.Inject
import kotlin.random.Random

class MockNotesRepositoryImpl @Inject constructor() : NotesRepository {

    override suspend fun getNotes(): List<Note> {
        delay(500)
        return if (Random.nextBoolean()) {
            throw Exception("Error message")
        } else {
            NotesMock.notesResponse.toNotes()
        }
//        return NotesMock.notesResponse.toNotes()
    }
}
