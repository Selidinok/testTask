package com.example.testtask.create.presentation

import app.cash.turbine.test
import com.example.testtask.create.domain.CreateInteractor
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CreateViewModelTest {
    private val interactor: CreateInteractor = mockk()

    private val viewModel = CreateViewModel(interactor)

    private val data = CreateData()

    @Test
    fun `onRefresh with id`() = runTest {
        coEvery { interactor.getNote(any()) } returns data

        viewModel.onRefresh("1")

        viewModel.state.test {
            assertEquals(data, awaitItem().data)
        }
    }

    @Test
    fun `onRefresh without id`() = runTest {
        viewModel.onRefresh(null)

        viewModel.state.test {
            assertEquals(false, awaitItem().isLoading)
        }
    }

    @Test
    fun `onRefresh with error`() = runTest {
        val message = "error"
        coEvery { interactor.getNote(any()) } throws Exception(message)

        viewModel.onRefresh("1")

        viewModel.state.test {
            assertEquals(message, awaitItem().error)
        }
    }

    @Test
    fun `onTitleChange with text`() = runTest {
        val text = "text"

        viewModel.onTitleChange(text)

        viewModel.state.test {
            assertEquals(text, awaitItem().data.title)
        }
    }

    @Test
    fun `onBodyChange with text`() = runTest {
        val text = "text"

        viewModel.onBodyChange(text)

        viewModel.state.test {
            assertEquals(text, awaitItem().data.body)
        }
    }

    @Test
    fun `onSave with result`() = runTest {
        val note = CreateData("2")
        coEvery { interactor.addNote(any()) } returns note

        viewModel.onSave()

        viewModel.state.test {
            assertEquals(note, awaitItem().data)
        }
    }

    @Test
    fun `onSave with error`() = runTest {
        val message = "error"
        coEvery { interactor.addNote(any()) } throws Exception(message)

        viewModel.onSave()

        viewModel.state.test {
            assertEquals(message, awaitItem().error)
        }
    }

}