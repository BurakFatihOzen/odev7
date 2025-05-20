package com.example.todoapp.di

import android.content.Context
import androidx.room.Room
import com.example.todoapp.data.ToDoDatabase
import com.example.todoapp.data.ToDoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Context): ToDoDatabase {
        return Room.databaseBuilder(app, ToDoDatabase::class.java, "todo_db").build()
    }

    @Provides
    fun provideDao(db: ToDoDatabase): ToDoDao = db.todoDao()
}
