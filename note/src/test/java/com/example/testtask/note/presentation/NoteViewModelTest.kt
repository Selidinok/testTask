package com.example.testtask.note.presentation

import app.cash.turbine.test
import com.example.testtask.note.domain.NoteInteractor
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@OptIn(ExperimentalCoroutinesApi::class)
class NoteViewModelTest {

    private val interactor: NoteInteractor = mockk()

    private lateinit var viewModel: NoteViewModel

    @BeforeEach
    fun setUp() {
        viewModel = NoteViewModel(interactor)
    }

    @Test
    fun `onRefresh get note`() = runTest {
        val data = NoteData("1")
        coEvery { interactor.getNote(any()) } returns data

        viewModel.onRefresh("1")

        viewModel.state.test {
            assertEquals(data, awaitItem().data)
        }
    }

    @Test
    fun `onRefresh get error`() = runTest {
        val message = "error"
        coEvery { interactor.getNote(any()) } throws Exception(message)

        viewModel.onRefresh("1")
        advanceUntilIdle()

        viewModel.state.test {
            assertEquals(message, awaitItem().error)
        }
    }
}