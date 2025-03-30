package com.example.testtask.note.domain

import com.example.testtask.api.data.NotesMock
import com.example.testtask.api.data.mapper.toNote
import com.example.testtask.api.domain.NotesRepository
import com.example.testtask.note.domain.mapper.NoteMapper
import com.example.testtask.note.presentation.NoteData
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NoteInteractorTest {

    private val repository: NotesRepository = mockk()
    private val mapper: NoteMapper = mockk()

    private val interactor = NoteInteractor(repository, mapper)

    @Test
    fun `getNote with result`() = runTest {
        val data = NoteData()
        coEvery { repository.getNote(any()) } returns NotesMock.note.toNote()
        coEvery { mapper.map(any()) } returns data

        val result = interactor.getNote("1")

        assertEquals(data, result)
        coVerify { repository.getNote(any()) }
        coVerify { mapper.map(any()) }
    }
}