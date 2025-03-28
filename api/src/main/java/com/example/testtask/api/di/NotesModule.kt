package com.example.testtask.api.di

import com.example.testtask.api.BuildConfig
import com.example.testtask.api.data.MockNotesRepositoryImpl
import com.example.testtask.api.data.NotesRepositoryImpl
import com.example.testtask.api.domain.NotesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NotesModule {

    @Provides
    fun bindNotesRepository(
        notesRepository: NotesRepositoryImpl,
        mockRepository: MockNotesRepositoryImpl,
    ): NotesRepository =
        if (BuildConfig.DEBUG) {
            mockRepository
        } else {
            notesRepository
        }
}
