package com.example.testtask.api.di

import com.example.testtask.api.data.MockNotesRepositoryImpl
import com.example.testtask.api.domain.NotesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface NotesModule {

    @Binds
    fun bindNotesRepository(notesRepository: MockNotesRepositoryImpl): NotesRepository
}
