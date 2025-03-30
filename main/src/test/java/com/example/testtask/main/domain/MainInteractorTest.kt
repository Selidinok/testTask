package com.example.testtask.main.domain

import com.example.testtask.api.data.NotesMock
import com.example.testtask.api.data.mapper.toNotes
import com.example.testtask.api.domain.NotesRepository
import com.example.testtask.main.domain.mapper.MainMapper
import com.example.testtask.main.presentation.NoteState
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MainInteractorTest {
    private val repository: NotesRepository = mockk()
    private val mainMapper: MainMapper = mockk()

    private val interactor = MainInteractor(repository, mainMapper)

    @Test
    fun `getNoteState with result`() = runTest {
        val data = listOf(NoteState("", "", ""))
        coEvery { mainMapper.map(any()) } returns data
        coEvery { repository.getNotes() } returns NotesMock.notesResponse.toNotes()

        val result = interactor.getNoteState()

        assertEquals(data, result)
        coVerify { repository.getNotes() }
        coVerify { mainMapper.map(any()) }
    }
}