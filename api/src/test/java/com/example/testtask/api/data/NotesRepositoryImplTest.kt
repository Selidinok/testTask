package com.example.testtask.api.data

import com.example.testtask.api.data.api.NotesApi
import com.example.testtask.api.data.mapper.toNote
import com.example.testtask.api.data.mapper.toNotes
import com.example.testtask.api.domain.entities.Note
import com.example.testtask.api.domain.entities.NoteCreationRequest
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NotesRepositoryImplTest {

    private val api: NotesApi = mockk()
    private val dispatcher: CoroutineDispatcher = Dispatchers.Unconfined

    private val repository = NotesRepositoryImpl(api, dispatcher)

    @Test
    fun getNotes() = runTest {
        coEvery { api.getNotes() } returns NotesMock.notesResponse

        val result = repository.getNotes()

        assertEquals(NotesMock.notesResponse.toNotes(), result)
    }

    @Test
    fun getNote() = runTest {
        coEvery { api.getNote("1") } returns NotesMock.note

        val result = repository.getNote("1")

        assertEquals(NotesMock.note.toNote(), result)
    }

    @Test
    fun createNote() = runTest {
        coEvery { api.createNote(any()) } returns NotesMock.note

        val result = repository.createNote(NoteCreationRequest("", ""))

        assertEquals(NotesMock.note.toNote(), result)
    }

    @Test
    fun updateNote() = runTest {
        coEvery { api.updateNote(any()) } returns NotesMock.note

        val result = repository.updateNote(Note("", "", ""))

        assertEquals(NotesMock.note.toNote(), result)
    }
}