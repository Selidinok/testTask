package com.example.testtask.create.domain

import com.example.testtask.api.data.NotesMock
import com.example.testtask.api.data.mapper.toNote
import com.example.testtask.api.domain.NotesRepository
import com.example.testtask.api.domain.entities.Note
import com.example.testtask.api.domain.entities.NoteCreationRequest
import com.example.testtask.create.domain.mapper.CreateMapper
import com.example.testtask.create.presentation.CreateData
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CreateInteractorTest {

    private val repository: NotesRepository = mockk()
    private val mapper: CreateMapper = mockk()

    private val interactor = CreateInteractor(repository, mapper)

    @Test
    fun `getNote with result`() = runTest {
        val data = CreateData()
        coEvery { repository.getNote(any()) } returns NotesMock.note.toNote()
        coEvery { mapper.map(any()) } returns data

        val result = interactor.getNote("1")

        assertEquals(data, result)
        coVerify { repository.getNote(any()) }
        coVerify { mapper.map(any()) }
    }

    @Test
    fun `addNote without id`() = runTest {
        val data = CreateData()
        coEvery { mapper.map(any()) } returns data
        coEvery { mapper.mapCreationRequest(any()) } returns NoteCreationRequest("", "")
        coEvery { repository.createNote(any()) } returns NotesMock.note.toNote()

        val result = interactor.addNote(data)

        assertEquals(data, result)
        coVerify { repository.createNote(any()) }
        coVerify { mapper.map(any()) }
        coVerify { mapper.mapCreationRequest(any()) }
    }

    @Test
    fun `addNote with id`() = runTest {
        val data = CreateData(id = "1")
        coEvery { mapper.map(any()) } returns data
        coEvery { mapper.mapNote(any()) } returns Note("", "", "")
        coEvery { repository.updateNote(any()) } returns NotesMock.note.toNote()

        val result = interactor.addNote(data)

        assertEquals(data, result)
        coVerify { repository.updateNote(any()) }
        coVerify { mapper.map(any()) }
        coVerify { mapper.mapNote(any()) }
    }
}