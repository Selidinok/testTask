package com.example.testtask.api.data

import com.example.testtask.api.data.mapper.toNote
import com.example.testtask.api.data.mapper.toNotes
import com.example.testtask.api.domain.entities.Note
import com.example.testtask.api.domain.entities.NoteCreationRequest
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MockNotesRepositoryImplTest {

    private val repository = MockNotesRepositoryImpl()

    @Test
    fun getNotes() = runTest {
        val result = repository.getNotes()

        assertEquals(NotesMock.notesResponse.toNotes(), result)
    }

    @Test
    fun getNote() = runTest {
        val result = repository.getNote("1")

        assertEquals(NotesMock.note.toNote(), result)
    }

    @Test
    fun createNote() = runTest {
        val result = repository.createNote(NoteCreationRequest("", ""))

        assertEquals(NotesMock.note.toNote(), result)
    }

    @Test
    fun updateNote() = runTest {
        val result = repository.updateNote(Note("", "", ""))

        assertEquals(NotesMock.note.toNote(), result)
    }
}