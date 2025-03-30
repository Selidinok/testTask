package com.example.testtask.main.presentation

import app.cash.turbine.test
import com.example.testtask.main.domain.MainInteractor
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MainViewModelTest {

    private val interactor: MainInteractor = mockk()

    private val viewModel = MainViewModel(interactor)

    private val notes = listOf(NoteState("1", "1", "1"))

    @Test
    fun `onRefresh get notes`() = runTest {
        coEvery { interactor.getNoteState() } returns notes

        viewModel.onRefresh()

        viewModel.state.test {
            assertEquals(true, awaitItem().isLoading)
            assertEquals(notes, awaitItem().notes)
        }
    }

    @Test
    fun `onRefresh get error`() = runTest {
        val message = "error"
        coEvery { interactor.getNoteState() } throws Exception(message)

        viewModel.onRefresh()

        viewModel.state.test {
            assertEquals(message, awaitItem().error)
        }
    }
}